package com.pj.flow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowRecruitMapper;
import com.pj.flow.pojo.FlowRecruit;
import com.pj.flow.service.FlowRecruitService;
import com.pj.system.mapper.CompanyMapper;
import com.pj.system.mapper.DempMapper;
import com.pj.system.mapper.UserMapper;
import com.pj.system.pojo.User;

@Transactional
@Service
public class FlowRecruitServiceImpl extends AbstractBaseServiceImpl<FlowRecruit, Integer> implements FlowRecruitService {

	@Autowired
	private FlowRecruitMapper flowRecruitMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private DempMapper dempMapper;
	
	@Override
	public MyMapper<FlowRecruit> getMapper() {
		return flowRecruitMapper;
	}
	@Override
	public User getLeader(Integer companyId, Integer dempId, Integer isCompanyLeader, Integer isDempLeader) {
		/**
		 * 1，dempId=null,不是公司领导，找公司负责人
		 * 				    是公司领导，找上级公司的负责人
		 * 2，dempId!=null,不是部门领导，找部门负责人
		 * 				      是部门领导，找组织架构上级负责人
		 */
		User user = new User();
		if(dempId == null){
			if(isCompanyLeader == 0){
				//不是公司领导
				//查找部门表找出该公司下所有部门id,再去user表根据部门id找到公司负责人
				user = userMapper.getCompanyLeader(companyId);
			}else{
				//是公司领导
				//查找上级公司id
				int pId = companyMapper.selectByPrimaryKey(companyId).getpId();
				user = userMapper.getCompanyLeader(pId);
			}
		}else{
			if(isDempLeader == 0){
				//不是部门领导
				//查询user表根据dempId得到部门负责人
				user = userMapper.getDempLeader(dempId);
			}else{
				//部门领导
				//查找上级部门id
				int pId = dempMapper.selectByPrimaryKey(dempId).getpId();
				user = userMapper.getDempLeader(pId);
			}
		}
		
		return user;
	}

}
