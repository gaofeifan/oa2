package com.pj.flow.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.service.AuthAgencyService;
import com.pj.config.base.constant.ActionLogOperation;
import com.pj.config.base.constant.ApplyType;
import com.pj.config.base.constant.EntryApplyResult;
import com.pj.config.base.constant.EntryApplyState;
import com.pj.config.base.constant.RecruitApplyResult;
import com.pj.config.base.constant.RecruitApplyState;
import com.pj.config.base.constant.RecruitTodoState;
import com.pj.config.base.constant.SalaryType;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowActionLogMapper;
import com.pj.flow.mapper.FlowEntryMapper;
import com.pj.flow.mapper.FlowRecruitMapper;
import com.pj.flow.mapper.FlowRecruitTodoMapper;
import com.pj.flow.mapper.FlowUserApplicationMapper;
import com.pj.flow.pojo.FlowActionLog;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowOffer;
import com.pj.flow.pojo.FlowRecruit;
import com.pj.flow.pojo.FlowRecruitTodo;
import com.pj.flow.pojo.FlowUserApplication;
import com.pj.flow.service.FlowActionLogService;
import com.pj.flow.service.FlowEntryService;
import com.pj.flow.service.FlowRecruitTodoService;
import com.pj.system.mapper.CompanyMapper;
import com.pj.system.mapper.SalaryMapper;
import com.pj.system.mapper.UserMapper;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Position;
import com.pj.system.pojo.Salary;
import com.pj.system.pojo.User;
import com.pj.system.service.DempService;
import com.pj.system.service.PositionService;
import com.pj.system.service.SalaryService;
import com.pj.system.service.UserService;
import com.pj.utils.AESUtils;
import com.pj.utils.DigitalConversionUtils;
import com.pj.utils.OfferUtils;
import com.pj.utils.SendEmailUtils;

import net.sf.json.JSONArray;

@Transactional
@Service
public class FlowEntryServiceImpl extends AbstractBaseServiceImpl<FlowEntry, Integer> implements FlowEntryService {

	@Resource
	private FlowEntryMapper flowEntryMapper;
	
	@Resource
	private FlowRecruitTodoMapper flowRecruitTodoMapper;	
	@Resource
	private SalaryMapper salaryMapper;
	@Autowired
	private SalaryService salaryService;
	@Autowired
	private UserService userService;
	@Autowired
	private DempService dempService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private FlowRecruitMapper flowRecruitMapper;
	@Autowired
	private AuthAgencyService authAgencyService;
	@Autowired
	private FlowActionLogMapper flowActionLogMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private FlowUserApplicationMapper flowUserApplicationMapper;
	@Autowired
	private FlowRecruitTodoService flowRecruitTodoService;
	@Autowired
	private FlowActionLogService flowActionLogService;
	@Override
	public MyMapper<FlowEntry> getMapper() {
		return flowEntryMapper;
	}
	@Override
	public void insertEntryAndSalary(FlowEntry flowEntry, String salarys) {
		FlowRecruit flowRecruit = flowRecruitMapper.selectByPrimaryKey(flowEntry.getRecruitId());
		
		flowEntry.setRecruitId(flowEntry.getRecruitId());
		flowEntry.setApplyId(flowRecruit.getApplyId());
		flowEntry.setUsername(flowRecruit.getUsername());
		flowEntry.setStatus(0);
		flowEntry.setState(EntryApplyState.IN_ENTRY_APPROVAL.getState());
		
		/**
		 * 先保存入职申请信息
		 * 得到入职表id,作为外键保存薪资表
		 */
		flowEntry.setApplyDate(new Date());
		flowEntryMapper.insertEntry(flowEntry);
		//更新招聘申请的状态:入职审批中，申请结果是空
		flowRecruit.setState(RecruitApplyState.IN_ENTRY_APPROVAL.getState());
		flowRecruit.setResult(0);
		flowRecruitMapper.updateByPrimaryKeySelective(flowRecruit);
		
		//保存薪资表
		Integer entryId = flowEntry.getId();
		JSONArray array = JSONArray.fromObject(salarys);
	    @SuppressWarnings("unchecked")
		List<Salary> list = JSONArray.toList(array, Salary.class);
		for(Salary salary : list){
			salary.setEntryId(entryId);
			salaryService.insertSelective(salary);
		}
		//申请人
		Integer userId = flowEntry.getApplyId();
		User user = this.userMapper.selectByPrimaryKey(userId);
		//申请人部门
		String dempName = this.dempService.selectDempParentNameById(user.getDempid());
		Company company = companyMapper.selectByPrimaryKey(user.getCompanyid());
		
		//保存中间表
		FlowUserApplication fa = new FlowUserApplication();
		
		fa.setFormId(entryId);
		fa.setUserId(userId);
		fa.setApplyName(flowEntry.getUsername());
		fa.setApplyTime(flowEntry.getApplyDate());
		fa.setApplyType(ApplyType.ENTRY.getApplyType());
		fa.setApplyDempName(dempName);
		fa.setApplyCompanyName(company.getName());
		flowUserApplicationMapper.insertSelective(fa);
		
		
		/***************招聘待办信息保存satrt**********/
		
		//若提交，提交入职申请后再更新到已提交栏目，招聘中状态减一
		//已提交的信息
		Integer recruitId = flowEntry.getRecruitId();
			
//		FlowRecruitTodo hasCommitTodo = flowRecruitTodoMapper.selectByRecruitId(recruitId, RecruitTodoState.HAS_COMMIT.getState());
//		if(hasCommitTodo != null){
//			hasCommitTodo.setNumber(hasCommitTodo.getNumber() + 1);
//			flowRecruitTodoMapper.updateByPrimaryKeySelective(hasCommitTodo);
//		}else{
		FlowRecruitTodo hasCommitTodo = new FlowRecruitTodo();
		hasCommitTodo.setRecruitId(recruitId);
		hasCommitTodo.setEntryId(entryId);
		hasCommitTodo.setState(RecruitTodoState.HAS_COMMIT.getState());
		hasCommitTodo.setNumber(1);
		hasCommitTodo.setStatus(0);
		flowRecruitTodoMapper.insert(hasCommitTodo);
//		}
		//招聘中状态的数据减一,如只有一个则更改状态status为1，多个则减一
		FlowRecruitTodo inRecruitTodo = flowRecruitTodoMapper.selectByRecruitId(recruitId, RecruitTodoState.IN_RECRUIT.getState());
		int num = inRecruitTodo.getNumber();
		if(num > 1){
			inRecruitTodo.setNumber(num - 1);
			flowRecruitTodoMapper.updateByPrimaryKeySelective(inRecruitTodo);
		}else{
			inRecruitTodo.setStatus(1);
			inRecruitTodo.setNumber(0);
			flowRecruitTodoMapper.updateByPrimaryKeySelective(inRecruitTodo);
		}
		
		//保存日志表
		FlowActionLog log = new FlowActionLog();
		log.setRecruitId(recruitId);
		log.setEntryId(entryId);
		log.setOperater(flowEntry.getUsername());
		log.setStatus(ActionLogOperation.COMMIT_ENTRY.getValue());
		log.setOperateTime(new Date());
		flowActionLogMapper.insert(log);
		
		/***************招聘待办信息保存end**********/
		/**
		 * 	保存入职消息通知
		 */
		/*MessageContent content = new MessageContent();
		//	查询招聘表
		if(flowRecruit != null){
			String names = this.dempService.selectDempParentNameById(flowRecruit.getDempId());
			content.setApplicatDemp(names);
			Position position = this.positionService.selectByPrimaryKey(flowRecruit.getPositionId());
			if(position != null){
				content.setApplicatPosition(position.getName());
			}
			content.setApplicatId(flowEntry.getId());
			content.setApplicatName(flowEntry.getUsername());
			content.setApplyTime(flowEntry.getApplyDate());
			content.setTitle(MessageType.ENTRY_MES.getDesc());
			content.setType(MessageType.ENTRY_MES.getValue());
		}
		messageContentService.addUnapprovedMessage(content);*/
		
		/**************************************/
		/*************获取并保存审批人员*************/
		/**************************************/
		FlowRecruit recruit = this.flowRecruitMapper.selectById(recruitId);
		Position position = this.positionService.selectByPrimaryKey(recruit.getPositionId());
		this.authAgencyService.selectApplicantAgency(recruit.getCompanyId() , recruit.getDempId(), recruit.getIsCompanyLeader(), recruit.getIsDempLeader(), position, recruit.getApplyReasonType(),fa.getId());
		/**************************************/
		/***************更新招聘状态***************/
		/**************************************/
		recruit.setState(RecruitApplyState.IN_ENTRY_APPROVAL.getState());
		recruit.setResult(null);
		this.flowRecruitMapper.updateByPrimaryKey(recruit);
	}
	
	@Override
	public FlowEntry selectById(Integer entryId) {
		FlowEntry flowEntry = flowEntryMapper.selectById(entryId);
		List<Salary> salarys = flowEntry.getSalarys();
		for (Salary salary : salarys) {
			salary = (Salary)AESUtils.aesEncryptionOrDecryption(salary, AESUtils.DECRYPTHEX);
		}
		return flowEntry;
	}

	/**
	 * 	offer展示的详情
	 */
	@Override
	public FlowOffer selectOfferDetailsByApplyIdAndEmail(Integer applyId, String email) {
		User user = this.userService.selectByEamil(email);
		FlowOffer flowOffer = this.flowEntryMapper.selectOfferDetailsByApplyId(applyId);
		List<Salary> list = this.salaryService.selectSalaryByEntryId(applyId);
		Salary sySalary = list.stream().filter(salary -> salary.getSalaryType() == SalaryType.SY.getIndex()).findFirst().get();
		@SuppressWarnings("unused")
		Salary sxSalary = list.stream().filter(salary -> salary.getSalaryType() == SalaryType.SX.getIndex()).findFirst().get();
		Salary zzSalary = list.stream().filter(salary -> salary.getSalaryType() == SalaryType.ZZ.getIndex()).findFirst().get();
	
		flowOffer.setBasePretaxSalaryForTrialPeriod(sySalary.getBaseSalary());
		flowOffer.setBasePretaxSalaryForTrialPeriodUpper(parseDouble(sySalary.getBaseSalary()));
		flowOffer.setPre_taxSalary(zzSalary.getBaseSalary());
		flowOffer.setPre_taxSalaryUpper(parseDouble(zzSalary.getBaseSalary()));
		
		flowOffer.setTheSalaryOfTheUsePeriod(sySalary.getPostSalary());
		flowOffer.setTheSalaryOfTheUsePeriodUpper(parseDouble(sySalary.getPostSalary()));
		flowOffer.setPostAPostSalary(zzSalary.getPostSalary());
		flowOffer.setPostAPostSalaryUpper(parseDouble(zzSalary.getPostSalary()));
		
		flowOffer.setProbationPerformanceSalary(sySalary.getPerformanceSalary());
		flowOffer.setProbationPerformanceSalaryUpper(parseDouble(sySalary.getPerformanceSalary()));
		flowOffer.setTransferPerformancePay(zzSalary.getPerformanceSalary());
		flowOffer.setTransferPerformancePayUpper(parseDouble(zzSalary.getPerformanceSalary()));
		
		flowOffer.setLunchAllowance(zzSalary.getLunchAllowance());
		flowOffer.setPhoneAllowance(zzSalary.getCommunicationAllowance());
		flowOffer.setPresentAtDutyEveryDay(zzSalary.getFullHours());
		
		flowOffer.setContacts(user.getUsername());
		flowOffer.setContactsPhone(user.getPhone());
		return flowOffer;
	}

	/**
	 * 	发送offer
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	@Override
	public void sendOffer(String iEamil, String usernames, String hour, Integer applyId, String email , String timeDivision, String emailPassword){
		User user = this.userService.selectByEamil(email);
		FlowEntry flowEntry = this.flowEntryMapper.selectByPrimaryKey(applyId);
		
		if(StringUtils.isNoneBlank(hour)){
			flowEntry.setHour(hour);
		}
		if(StringUtils.isNoneBlank(usernames)){
			flowEntry.setPeopleWhoCopied(usernames);
		}
		flowEntry.setState(EntryApplyState.IN_OFFER.getState());
		if(flowEntry.getResult() != null && flowEntry.getResult() != EntryApplyResult.ENTRY_CANCEL.getState()){
			flowEntry.setResult(null);
		}
		flowEntry.setIsSendOffer(1);
		this.flowEntryMapper.updateByPrimaryKey(flowEntry);
		
		//已发送offer删除已审批数据
		flowRecruitTodoService.changeState(applyId, EntryApplyState.IN_OFFER.getState(), null);
		
		
		FlowRecruit flowRecruit = this.flowRecruitMapper.selectByPrimaryKey(flowEntry.getRecruitId());
		flowRecruit.setState(RecruitApplyState.IN_OFFER.getState());
		if(flowRecruit.getResult() != null && flowRecruit.getResult() != RecruitApplyResult.ENTRY_CANCEL.getState()){
			flowRecruit.setResult(null);
		}
		this.flowRecruitMapper.updateByPrimaryKey(flowRecruit);
		
		FlowActionLog record = new FlowActionLog();
		record.setEntryId(flowEntry.getId());
		record.setRecruitId(flowEntry.getRecruitId());
		record.setOperateTime(new Date());	
		record.setStatus(ActionLogOperation.SEND_OFFER.getValue());
		record.setOpinion(user.getUsername());
		flowActionLogService.insert(record );
		
		Company company = this.companyMapper.selectByPrimaryKey(user.getCompanyid());
		//	获取offer内容
		FlowOffer offer = this.selectOfferDetailsByApplyIdAndEmail(applyId, email);
		offer.setContactsPosition(user.getPositionname());
		offer.setCompanyAddress(company.getAddress());
		offer.setCompanyPhone(company.getContact());
		offer.setContactsEmail(user.getCompanyEmail());
		//	设置抄送人
		String[] ccEmail = null;
		if(StringUtils.isNotBlank(usernames)){
			String[] emails = usernames.split(",");
			ccEmail = new String[emails.length];
			for (int i = 0; i < emails.length; i++) {
				if(StringUtils.isNotBlank(emails[i].toString())){
					ccEmail[i] = emails[i].trim();
				}
			}
		}
		//	获取offer模板
		String offerTemp = SendEmailUtils.getResourceTemp("/temp/offer2");
		offerTemp = OfferUtils.replaceOfferContent(offerTemp,offer);
		try {
			SendEmailUtils.sendMessage(email,emailPassword, iEamil, "offer-【"+offer.getUsername()+"】 "+offer.getCompany(), offerTemp, ccEmail);
		} catch (AddressException e) {
			throw new RuntimeException("邮箱格式有误 如:个人邮箱 lisi@163.com  抄送人 lisi@163.com,wangwu@163.com");
		} catch (MessagingException e) {
			throw new RuntimeException("邮箱密码错误");
		}
	}

	/**
	 * 	获取抄送人邮箱
	 *	@author 	GFF
	 *	@date		2017年6月27日下午1:30:17	
	 * 	@return
	 */
	public String[] getCCEmail(String usernames){
		usernames = usernames.trim();
		String[] username = usernames.split(",");
		String []CC = new String[username.length];
		for (int i = 0; i < username.length; i++) {
			List<User> list = this.userService.selectUserByUsername(username[i]);
			if(list.size() != 0){
				CC[i] = list.get(0).getCompanyEmail();
			}
		}
		return CC;
	}
	
	
	@Override
	public List<FlowEntry> searchEntrys(Integer companyId, String username, Integer userId) {
		return flowEntryMapper.searchEntrys(companyId, username, userId);
	}
//	@Override
//	public int getNumByAuthResult(Integer userId, int result) {
//		return flowEntryMapper.getNumByAuthResult(userId, result);
//	}
	@Override
	public List<FlowEntry> selectByTodo(Integer userId, Integer companyId, String name) {
		return flowEntryMapper.selectByTodo(userId, companyId, name);
	}

	private String parseDouble(String str){
		if(StringUtils.isBlank(str)){
			return "";
		}
		double d = Double.parseDouble(str);
		return DigitalConversionUtils.number2CNMontrayUnit(d);
	}
	@Override
	public void cancelEntry(Integer entryId) {
		FlowEntry flowEntry = flowEntryMapper.selectByPrimaryKey(entryId);
		flowEntry.setResult(EntryApplyResult.ENTRY_CANCEL.getState());
		flowEntry.setStatus(1);
		
		flowEntryMapper.updateByPrimaryKeySelective(flowEntry);
		
		FlowRecruit flowRecruit = flowRecruitMapper.selectByPrimaryKey(flowEntry.getRecruitId());
		flowRecruit.setResult(RecruitApplyResult.ENTRY_CANCEL.getState());
		flowRecruitMapper.updateByPrimaryKeySelective(flowRecruit);
		//入职撤回，招聘中+1
		flowRecruitTodoService.changeState(entryId, EntryApplyState.IN_OFFER.getState(), EntryApplyResult.ENTRY_CANCEL.getState());
	}
	
}
