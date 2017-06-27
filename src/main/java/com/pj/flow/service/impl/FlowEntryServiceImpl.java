package com.pj.flow.service.impl;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.constant.SalaryType;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowEntryMapper;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowOffer;
import com.pj.flow.service.FlowEntryService;
import com.pj.system.pojo.Salary;
import com.pj.system.pojo.User;
import com.pj.system.service.SalaryService;
import com.pj.system.service.UserService;
import com.pj.utils.AESUtils;
import com.pj.utils.DigitalConversionUtils;
import com.pj.utils.SendEmailUtils;

import io.swagger.annotations.ApiModelProperty;

@Transactional
@Service
public class FlowEntryServiceImpl extends AbstractBaseServiceImpl<FlowEntry, Integer> implements FlowEntryService {

	@Autowired
	private FlowEntryMapper flowEntryMapper;
	@Autowired
	private SalaryService salaryService;
	@Autowired
	private UserService userService;
	
	@Override
	public MyMapper<FlowEntry> getMapper() {
		return flowEntryMapper;
	}

	/**
	 * 	查询offer展示的详情
	 */
	@Override
	public FlowOffer selectOfferDetailsByApplyIdAndEmail(Integer applyId, String email) {
		User user = this.userService.selectByEamil(email);
		FlowOffer flowOffer = this.flowEntryMapper.selectOfferDetailsByApplyId(applyId);
		List<Salary> list = this.salaryService.selectSalaryByEntryId(applyId);
		for (Salary salary : list) {
			salary = (Salary) AESUtils.aesEncryptionOrDecryption(salary, AESUtils.DECRYPTHEX);
		}
		Salary sySalary = list.stream().filter(salary -> salary.getSalaryType() == SalaryType.SY.getIndex()).findFirst().get();
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
		flowOffer.setContacts(user.getUsername());
		flowOffer.setContactsPhone(user.getPhone());
		return flowOffer;
	}

	/**
	 * 	发送offer
	 */
	@Override
	public void sendOffer(String iEamil, String usernames, String hour, Integer applyId, String email) {
		User user = this.userService.selectByEamil(email);
		//	获取offer内容
		FlowOffer offer = this.selectOfferDetailsByApplyIdAndEmail(applyId, email);
		offer.setExpectedTimeOfArrivalYear(hour);
		//	设置抄送人
		String[] CC = null;
		if(StringUtils.isNotBlank(usernames)){
			CC = getCCEmail(usernames);
		}
		//	获取offer模板
		String offerTemp = SendEmailUtils.getResourceTemp("/temp/offer2");
		offerTemp = replaceOfferContent(offerTemp,offer);
		SendEmailUtils.sendMessage(email, user.getCompanyEmailPassword(), iEamil, offer.getCompany()+"offer", offerTemp, CC);
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
	
	/**
	 * 	将offer模板中的内容替换
	 *	@author 	GFF
	 *	@date		2017年6月27日上午11:40:42	
	 * 	@param offerTemp
	 * 	@param offer
	 * 	@return
	 */
	private String replaceOfferContent(String offerTemp, FlowOffer offer) {
		Class<? extends FlowOffer> clazz = offer.getClass();
		Field[] fields = clazz.getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				boolean b = field.isAnnotationPresent(ApiModelProperty.class);
				if (b) {
					Object fileValue = field.get(clazz);
					if (fileValue != null) {
						ApiModelProperty api = field.getDeclaredAnnotation(ApiModelProperty.class);
						String notes = api.notes();
						offerTemp.replaceAll(notes, fileValue.toString());
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return offerTemp;
	}

}
