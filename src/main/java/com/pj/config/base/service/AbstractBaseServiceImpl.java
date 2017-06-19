package com.pj.config.base.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

import com.pj.config.base.mapper.MyMapper;
import com.pj.system.pojo.Demp;
import com.pj.utils.ClassUtils;

import tk.mybatis.mapper.entity.Example;

/**
 * 通用service的实现类
 * @author GFF
 * @date 2017年3月17日下午5:10:43
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
public abstract class AbstractBaseServiceImpl<T,ID extends Serializable > implements BaseService<T,ID> {
	/**
	 * 	获取mapper（用于spring初始化base时nullpointerexception）
	 *	@author 	GFF
	 *	@date		2017年3月21日下午3:03:33	
	 * 	@return
	 */
	public abstract MyMapper<T> getMapper();
	
	
	/**
	 * 	根据条件查询
	 */
	@Override
	public List<T> select(T record) {
		return getMapper().select(record);
	}

	/**
	 * 	根据Example查询
	 */
	@Override
	public List<T> selectByExample(Example example) {
		return getMapper().selectByExample(example);
	}
	
	/**
	 * 	查询所有
	 */
	@Override
	public List<T> selectAll() {
		return getMapper().selectAll();
	}
	/**
	 * 	根据主键查询
	 */
	@Override
	public T selectByPrimaryKey(ID key) {
		return  getMapper().selectByPrimaryKey(key);
	}

	/**
	 * 	新增
	 */
	@Override
	public int insert(T t) {
		return getMapper().insert(t);
	}

	/**
	 * 	新增（排除非空）
	 */
	@Override
	public int insertSelective(T t) {
		return getMapper().insertSelective(t);
	}

	/**
	 * 	新增(返回主键id)
	 */
	@Override
	public int insertUseGeneratedKeys(T t) {
		return getMapper().insertUseGeneratedKeys(t);
	}
	
	/**
	 * 	根据主键更新
	 */
	@Override
	public int updateByPrimaryKey(T record) {
		return getMapper().updateByPrimaryKey(record);
	}
	/**
	 * 	根据主键更新（排除null值）
	 */
	@Override
	public int updateByPrimaryKeySelective(T record) {
		return getMapper().updateByPrimaryKeySelective(record);
	}
	/**
	 * 	根据example更新
	 */
	@Override
	public int updateByExample(T record, Example example) {
		return getMapper().updateByExample(record, example);
	}
	/**
	 * 	根据example更新（排除null值）
	 */
	@Override
	public int updateByExampleSelective(T record, Example example) {
		return getMapper().updateByExampleSelective(record, example);
	}

	/**
	 * 	根据example
	 */
	@Override
	public int deleteByExample(Example example) {
		return getMapper().deleteByExample(example);
	}

	/**
	 *  根据条件删除 
	 */
	@Override
	public int delete(T record) {
		return getMapper().delete(record);
	}

	/**
	 * 	根据id删除
	 */
	@Override
	public int deleteByPrimaryKey(ID id) {
		return getMapper().deleteByPrimaryKey(id);
	}

	/**
	 *  查询最后的number编号
	 */
	@Override
	public String selectEndNumber() {
		List<T> list = getMapper().selectAll();
		List<String> values = null;
		if(list.size() != 0){
			values = ClassUtils.getGetMethodValue(list.get(list.size() - 1 ), Arrays.asList("number"));
		}
		return values.size() != 0 ? values.get(0) : null;
	}

	/**
	 * 查询所有未删除的结果集
	 */
	@Override
	public List<T> selectNotDeleteALL() {
		Example example = new Example(Demp.class);
		example.createCriteria().andCondition(" isdelete = 0");
		return getMapper().selectByExample(example );
	}
	
	/**
	 * 	根据id删除数据(逻辑删除)
	 */
	@Override
	public int deleteByPrimaryKeyToLogic(ID id) {
		T t = ClassUtils.setFieldValue(clazz , Arrays.asList("id","isdelete"),Arrays.asList(id,1));
		return getMapper().updateByPrimaryKeySelective(t);
	}

	@SuppressWarnings("unchecked")
	public AbstractBaseServiceImpl() {
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}
	
	private Class<T> clazz;

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	


	
	
	
	
	
	
	
}
