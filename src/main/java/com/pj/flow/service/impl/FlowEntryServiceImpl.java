package com.pj.flow.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowEntryMapper;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.service.FlowEntryService;
import com.pj.system.mapper.SalaryMapper;
import com.pj.system.pojo.Salary;

import net.sf.json.JSONArray;

@Transactional
@Service
public class FlowEntryServiceImpl extends AbstractBaseServiceImpl<FlowEntry, Integer> implements FlowEntryService {

	@Resource
	private FlowEntryMapper flowEntryMapper;
	
	@Resource
	private SalaryMapper salaryMapper;
	
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
		flowEntryMapper.insertUseGeneratedKeys(flowEntry);
		//保存薪资表
		Integer entryId = flowEntry.getId();
		JSONArray array = JSONArray.fromObject(salarys);
	    @SuppressWarnings("unchecked")
		List<Salary> list = JSONArray.toList(array, Salary.class);
		for(Salary salary : list){
			salary.setEntryId(entryId);
			salaryMapper.insertSelective(salary);
		}
	}
	@Override
	public List<FlowEntry> selectById(Integer entryId) {
		List<FlowEntry> list = flowEntryMapper.selectById(entryId);
		
		return list;
	}

}
