package com.pj.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.RankMapper;
import com.pj.system.pojo.Rank;
import com.pj.system.service.RankService;

import tk.mybatis.mapper.entity.Example;

@Transactional
@Service
public class RankServiceImpl extends AbstractBaseServiceImpl<Rank, Integer> implements RankService {

	@Resource
	private RankMapper rankMapper;

	@Override
	public MyMapper<Rank> getMapper() {
		return rankMapper;
	}

	/**
	 * 	根据名称查询
	 */
	@Override
	public Integer selectByName(String rankName) {
		Example example = new Example(Rank.class);
		example.createCriteria().andCondition(" name LIKE "+"%"+rankName+"%").andCondition(" isdelete = 0 ");
		List<Rank> list = this.rankMapper.selectByExample(example);
		return list.size() != 0 ?list.get(0).getId():null;
	}

}
