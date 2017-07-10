package com.pj.flow.service.impl;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.service.AuthAgencyService;
import com.pj.config.base.constant.ActionLogOperation;
import com.pj.config.base.constant.ApplyType;
import com.pj.config.base.constant.MessageType;
import com.pj.config.base.constant.RecruitTodoState;
import com.pj.config.base.constant.SalaryType;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowActionLogMapper;
import com.pj.flow.mapper.FlowEntryMapper;
import com.pj.flow.mapper.FlowRecruitTodoMapper;
import com.pj.flow.mapper.FlowUserApplicationMapper;
import com.pj.flow.pojo.FlowActionLog;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowOffer;
import com.pj.flow.pojo.FlowRecruit;
import com.pj.flow.pojo.FlowRecruitTodo;
import com.pj.flow.pojo.FlowUserApplication;
import com.pj.flow.service.FlowEntryService;
import com.pj.flow.service.FlowRecruitService;
import com.pj.message.pojo.MessageContent;
import com.pj.message.service.MessageContentService;
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
	private MessageContentService messageContentService;
	@Autowired
	private DempService dempService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private FlowRecruitService flowRecruitService;
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
	
	@Override
	public MyMapper<FlowEntry> getMapper() {
		return flowEntryMapper;
	}
	@Override
	public void insertEntryAndSalary(FlowEntry flowEntry, String salarys) {
		/**
		 * 先保存入职申请信息
		 * 得到入职表id,作为外键保存薪资表
		 */
		flowEntry.setApplyDate(new Date());
		flowEntryMapper.insertEntry(flowEntry);
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
		
		flowUserApplicationMapper.insertUseGeneratedKeys(fa);
		
		
		/***************招聘待办信息保存satrt**********/
		
		//若提交，提交入职申请后再更新到已提交栏目，招聘中状态减一
		//已提交的信息
		int recruitId = flowEntry.getRecruitId();
		FlowRecruitTodo hasCommitTodo = flowRecruitTodoMapper.selectByRecruitId(recruitId, RecruitTodoState.HAS_COMMIT.getState());
		if(hasCommitTodo != null){
			hasCommitTodo.setNumber(hasCommitTodo.getNumber() + 1);
			flowRecruitTodoMapper.updateByPrimaryKeySelective(hasCommitTodo);
		}else{
			hasCommitTodo = new FlowRecruitTodo();
			hasCommitTodo.setRecruitId(recruitId);
			hasCommitTodo.setState(RecruitTodoState.HAS_COMMIT.getState());
			hasCommitTodo.setNumber(1);
			flowRecruitTodoMapper.insert(hasCommitTodo);
		}
		//招聘中状态的数据减一,如只有一个则删除，多个则减一
		FlowRecruitTodo inRecruitTodo = flowRecruitTodoMapper.selectByRecruitId(recruitId, RecruitTodoState.IN_RECRUIT.getState());
		int num = inRecruitTodo.getNumber();
		if(num > 1){
			inRecruitTodo.setNumber(num - 1);
			flowRecruitTodoMapper.updateByPrimaryKeySelective(inRecruitTodo);
		}else{
			flowRecruitTodoMapper.delete(inRecruitTodo);
		}
		
		//保存日志表
		FlowActionLog log = new FlowActionLog();
		log.setRecruitId(recruitId);
		log.setOperater(flowEntry.getUsername());
		log.setStatus(ActionLogOperation.COMMIT_ENTRY.getValue());
		log.setOperateTime(new Date());
		flowActionLogMapper.insert(log);
		
		/***************招聘待办信息保存end**********/
		/**
		 * 	保存入职消息通知
		 */
		MessageContent content = new MessageContent();
		//	查询招聘表
		FlowRecruit flowRecruit = this.flowRecruitService.selectById(flowEntry.getRecruitId());
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
		messageContentService.addUnapprovedMessage(content);
		
		/**
		 * 	获取并保存审批人员
		 * 
		 */
		FlowRecruit recruit = this.flowRecruitService.selectById(flowEntry.getRecruitId());
		Position position = this.positionService.selectByPrimaryKey(recruit.getPositionId());
		this.authAgencyService.selectApplicantAgency(recruit.getCompanyId() , recruit.getDempId(), recruit.getIsCompanyLeader(), recruit.getIsDempLeader(), position, recruit.getApplyReasonType(),fa.getId());
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
//		for (Salary salary : list) {
//			salary = (Salary) AESUtils.aesEncryptionOrDecryption(salary, AESUtils.DECRYPTHEX);
//		}
		Salary sySalary = list.stream().filter(salary -> salary.getSalaryType() == SalaryType.SY.getIndex()).findFirst().get();
		@SuppressWarnings("unused")
		Salary sxSalary = list.stream().filter(salary -> salary.getSalaryType() == SalaryType.SX.getIndex()).findFirst().get();
		Salary zzSalary = list.stream().filter(salary -> salary.getSalaryType() == SalaryType.ZZ.getIndex()).findFirst().get();
	
		flowOffer.setBasePretaxSalaryForTrialPeriod(sySalary.getBaseSalary());
		flowOffer.setBasePretaxSalaryForTrialPeriodUpper(DigitalConversionUtils.number2CNMontrayUnit( Double.parseDouble(sySalary.getBaseSalary())));
		flowOffer.setPre_taxSalary(zzSalary.getBaseSalary());
		flowOffer.setPre_taxSalaryUpper(DigitalConversionUtils.number2CNMontrayUnit( Double.parseDouble(zzSalary.getBaseSalary())));
		
		flowOffer.setTheSalaryOfTheUsePeriod(sySalary.getPostSalary());
		flowOffer.setTheSalaryOfTheUsePeriodUpper(DigitalConversionUtils.number2CNMontrayUnit( Double.parseDouble(sySalary.getPostSalary())));
		flowOffer.setPostAPostSalary(zzSalary.getPostSalary());
		flowOffer.setPostAPostSalaryUpper(DigitalConversionUtils.number2CNMontrayUnit( Double.parseDouble(zzSalary.getPostSalary())));
		
		flowOffer.setProbationPerformanceSalary(sySalary.getPerformanceSalary());
		flowOffer.setProbationPerformanceSalaryUpper(DigitalConversionUtils.number2CNMontrayUnit( Double.parseDouble(sySalary.getPerformanceSalary())));
		flowOffer.setTransferPerformancePay(zzSalary.getPerformanceSalary());
		flowOffer.setTransferPerformancePayUpper(DigitalConversionUtils.number2CNMontrayUnit( Double.parseDouble(zzSalary.getPerformanceSalary())));
		
		flowOffer.setLunchAllowance(zzSalary.getLunchAllowance());
		flowOffer.setPhoneAllowance(zzSalary.getCommunicationAllowance());
		flowOffer.setPresentAtDutyEveryDay(zzSalary.getFullHours());
		
		flowOffer.setContacts(user.getUsername());
		flowOffer.setContactsPhone(user.getPhone());
		return flowOffer;
	}

	/**
	 * 	发送offer
	 */
	@Override
	public void sendOffer(String iEamil, String usernames, String hour, Integer applyId, String email , String timeDivision) {
		User user = this.userService.selectByEamil(email);
		FlowEntry flowEntry = this.flowEntryMapper.selectByPrimaryKey(applyId);
		if(StringUtils.isNoneBlank(hour)){
			flowEntry.setHour(hour);
		}
		if(StringUtils.isNoneBlank(usernames)){
			flowEntry.setPeopleWhoCopied(usernames);
		}
		this.flowEntryMapper.updateByPrimaryKeySelective(flowEntry);
		
		//	获取offer内容
		FlowOffer offer = this.selectOfferDetailsByApplyIdAndEmail(applyId, email);
		//	设置抄送人
		Object[] ccEmail = null;
		if(StringUtils.isNotBlank(usernames)){
			Set<String> set = new HashSet<>();
			String[] emails = usernames.split(",");
			for (int i = 0; i < emails.length; i++) {
				if(StringUtils.isNotBlank(emails[i].toString())){
					set.add(emails[i]);
				}
			}
			ccEmail = set.toArray();
		}
		//	获取offer模板
		String offerTemp = SendEmailUtils.getResourceTemp("/temp/offer2");
		offerTemp = OfferUtils.replaceOfferContent(offerTemp,offer);
		SendEmailUtils.sendMessage(email, user.getCompanyEmailPassword(), iEamil, offer.getCompany()+"offer", offerTemp, ccEmail);
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
	@Override
	public int getNumByAuthResult(Integer userId, int result) {
		return flowEntryMapper.getNumByAuthResult(userId, result);
	}
	@Override
	public List<FlowEntry> selectByTodo(Integer userId, Integer companyId, String name) {
		return flowEntryMapper.selectByTodo(userId, companyId, name);
	}

	
}
