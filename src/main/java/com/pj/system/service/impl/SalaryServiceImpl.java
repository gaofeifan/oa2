package com.pj.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.SalaryMapper;
import com.pj.system.pojo.Salary;
import com.pj.system.service.SalaryService;
import com.pj.utils.AESUtils;

import tk.mybatis.mapper.entity.Example;

/**
 *	@author		GFF
 *	@date		2017年6月22日下午3:48:49
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class SalaryServiceImpl extends AbstractBaseServiceImpl<Salary, Integer> implements SalaryService {

	@Resource
	private SalaryMapper salaryMapper;
	
	@Override
	public MyMapper<Salary> getMapper() {
		return salaryMapper;
	}

	@Override
	public int insert(Salary t) {
		return super.insert(encryptHex(t));
	}

	@Override
	public int insertSelective(Salary t) {
		return super.insertSelective(encryptHex(t));
	}

	@Override
	public int insertUseGeneratedKeys(Salary t) {
		return super.insertUseGeneratedKeys(encryptHex(t));
	}
	
	@Override
	public int updateByPrimaryKey(Salary record) {
		return super.updateByPrimaryKey(encryptHex(record));
	}

	@Override
	public int updateByPrimaryKeySelective(Salary record) {
		return super.updateByPrimaryKeySelective(encryptHex(record));
	}

	@Override
	public int updateByExample(Salary record, Example example) {
		return super.updateByExample(encryptHex(record), example);
	}

	@Override
	public int updateByExampleSelective(Salary record, Example example) {
		return super.updateByExampleSelective(encryptHex(record), example);
	}
	
	/**
	 * 	通过用户查询薪资
	 */
	public List<Salary> selectSalaryByUserId(Integer userId){
		return selectSalaryByCondition("user_id", userId);
	}

	/**
	 * 	通过入职申请单查询
	 */
	public List<Salary> selectSalaryByEntryId(Integer entryId){
		return selectSalaryByCondition("entry_id", entryId);
	}
	
	
	private List<Salary> selectSalaryByCondition(String fieldName , Integer entryId){
		Example example = new Example(Salary.class);
		example.createCriteria().andCondition(fieldName+" = ", entryId);
		List<Salary> list = selectByExample(example );
		for (Salary salary : list) {
			salary = (Salary)AESUtils.aesEncryptionOrDecryption(salary, AESUtils.DECRYPTHEX);
		}
		return list;
	}
	
	private Salary encryptHex(Salary salary){
		return (Salary)AESUtils.aesEncryptionOrDecryption(salary,AESUtils.ENCRYPTHEX);
	}
	
	private Salary decryptHex(Salary salary){
		return (Salary)AESUtils.aesEncryptionOrDecryption(salary,AESUtils.ENCRYPTHEX);
	}

	@SuppressWarnings("unused")
	private List<Salary> decryptHexList(List<Salary> salarys){
		for (Salary salary : salarys) {
			salary = decryptHex(salary);
		}
		return salarys;
	}

	/**
	 * 	查询未加密薪资根据用户id
	 */
	@Override
	public List<Salary> selectUnencryptedSalaryByUserId(Integer id) {
		Example example = new Example(Salary.class);
		example.createCriteria().andCondition("user_id"+" = ", id);
		return selectByExample(example );
	}

	/**
	 * 	更新用户薪资不进行加密
	 */
	@Override
	public void updateByPrimaryKeyNoEncryption(Salary salary) {
		this.salaryMapper.updateByPrimaryKeySelective(salary);
	}

	

}
