package com.pj.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.PositionMapper;
import com.pj.system.pojo.Position;
import com.pj.system.pojo.User;
import com.pj.system.service.PositionService;
import com.pj.system.service.UserService;

import tk.mybatis.mapper.entity.Example;

@Transactional
@Service
public class PositionServiceImpl extends AbstractBaseServiceImpl<Position, Integer> implements PositionService {

	@Resource
	private PositionMapper positionMapper;
	@Resource
	private UserService userService;


	/**
	 * 
	 */
	@Override
	public MyMapper<Position> getMapper() {
		return positionMapper;
	}
	/**
	 * 根据名称查询
	 */
	@Override
	public Integer selectByName(String positionName) {
		Example example = new Example(Position.class);
		if(StringUtils.isNotBlank(positionName)){
			example.createCriteria().andCondition(" name LIKE "+"%"+positionName+"%").andCondition(" isdelete = 0 ");
		}
		List<Position> list = this.positionMapper.selectByExample(example);
		return list.size() != 0 ? list.get(0).getId() : null;
	}
	/**
	 * 根据岗位id查询职位
	 */
	@Override
	public Position selectByPostId(Integer originalpostid) {
		Position position = this.positionMapper.selectByPostId(originalpostid);
		return position;
	}
	/**
	 * 	查询是否可以删除
	 */
	@Override
	public Boolean isDeletePosition(Integer positionId) {
		User record = new User();
		record.setPositionid(positionId);
		record.setIsdelete(1);
		List<User> list = userService.select(record );
		return list.size() == 0 ? true:false;
	}
	
	/**
	 * 	获取上级级别的职位信息
	 */
	@Override
	public Position selectSuperiorPositionById(int positionId) {
		return this.positionMapper.selectSuperiorPositionById(positionId);
	}
	
	/**
	 * 	根据职位等级查询职位
	 */
	@Override
	public Position selectPositionByGrade(int grade) {
		Position record = new Position();
		record.setGrade(grade);
		List<Position> list = this.select(record );
		return list.size() != 0 ? list.get(0) : null;
	}


}
