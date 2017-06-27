package com.pj.flow.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.web.controller.BaseController;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.service.FlowEntryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 项目名称：oa   
 * 类名称：EntryController   
 * 类描述：入职申请  
 * 创建人：limr   
 * 创建时间：2017年6月27日 下午1:40:49   
 * 修改人：limr   
 * 修改时间：2017年6月27日 下午1:40:49   
 * 修改备注：   
 * @version    
 *
 */
@Controller
@RequestMapping("/entry")
@Api(value="entry", description="入职申请", position=1)
public class EntryController extends BaseController{

	//	日志对象
	private static final Logger logger = LoggerFactory.getLogger(EntryController.class); 
	@Resource
	private FlowEntryService flowEntryService;
	
	/**
	 * 	提交申请
	 * [{"totalSalary(总工资)":111,"baseSalary(基本工资)":10,"postSalary(岗位工资)":1,"performanceSalary(绩效工资)":"200","reimbursement(报销金额)":200,"lunchAllowance(午餐补贴)":"200","communicationAllowance(通讯补贴)":"200","fullHours(全勤)":"200","salary_type":(1(实习))},
	    {"totalSalary(总工资)":111,"baseSalary(基本工资)":10,"postSalary(岗位工资)":1,"performanceSalary(绩效工资)":"200","reimbursement(报销金额)":200,"lunchAllowance(午餐补贴)":"200","communicationAllowance(通讯补贴)":"200","fullHours(全勤)":"200","salary_type":(2(试用))},
	    {"totalSalary(总工资)":111,"baseSalary(基本工资)":10,"postSalary(岗位工资)":1,"performanceSalary(绩效工资)":"200","reimbursement(报销金额)":200,"lunchAllowance(午餐补贴)":"200","communicationAllowance(通讯补贴)":"200","fullHours(全勤)":"200","salary_type":(3(转正))}
	   ]
	 */
	@ApiOperation(value = "提交入职申请", httpMethod = "GET", response=MappingJacksonValue.class, notes ="提交入职申请")
	@RequestMapping("/commitEntry.do")
	@ResponseBody
	public MappingJacksonValue commitEntry(@ModelAttribute("flowEntry") FlowEntry flowEntry,
						@ApiParam(value = "工资信息(json格式[{'totalSalary(总工资)':111,'baseSalary(基本工资)':10,'postSalary(岗位工资)':1,'performanceSalary(绩效工资)':'200','reimbursement(报销金额)':200,'lunchAllowance(午餐补贴)':'200','communicationAllowance(通讯补贴)':200,'fullHours(全勤)':200,'sal'ry_type':(1(实习))},{'totalSalary(总工资)':111,'baseSalary(基本工资)':10,'postSalary(岗位工资)':1,'performanceSalary(绩效工资)':200,'reimbursement(报销金额)':200,'lunchAllowance(午餐补贴)':200,'communicationAllowance(通讯补贴)':200,'fullHours(全勤)':200,'salary_type':(2(试用))},{'totalSalary(总工资)':111,'baseSalary(基本工资)':10,'postSalary(岗位工资)':1,'performanceSalary(绩效工资)':200,'reimbursement(报销金额)':200,'lunchAllowance(午餐补贴)':200,'communicationAllowance(通讯补贴)':200,'fullHours(全勤)':200,'salary_type':(3(转正))}])", required = false)@RequestParam(value = "salarys", required = false) String salarys){
		MappingJacksonValue map;
		try {
			flowEntryService.insertEntryAndSalary(flowEntry, salarys);
			map = this.successJsonp(null);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("提交入职申请");
		}
		return map;
	}
	@ApiOperation(value = "入职申请详情", httpMethod = "GET", response=MappingJacksonValue.class, notes ="入职申请详情")
	@RequestMapping("/showEntryApply.do")
	@ResponseBody
	public MappingJacksonValue showEntryApply(
			@ApiParam(value = "入职表id", required = true)@RequestParam(value = "entryId", required = false) Integer entryId){
		MappingJacksonValue map;
		try {
			List<FlowEntry> flowEntrys = flowEntryService.selectById(entryId);
			map = this.successJsonp(flowEntrys);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("入职申请详情");
		}
		return map;
	}
	
}
