package com.pj.config.base.service;

import java.io.Serializable;
import java.util.List;

import tk.mybatis.mapper.entity.Example;

/**
 * 	通用service
 *	@author		GFF
 *	@date		2017年3月17日下午5:09:08
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface BaseService  <T,ID extends Serializable> {
	/**
	 * 	根据条件查询
	 *	@author 	GFF
	 *	@date		2017年3月21日下午2:38:30	
	 * 	@param record
	 * 	@return
	 */
	public List<T> select(T record);
	
	/**
	 * 	根据Example查询
	 *  @author 	GFF
	 *	@date		2017年3月21日下午2:38:30	
	 * 	@param record
	 * 	@return
	 */
	public List<T> selectByExample(Example example);
	
	/**
	 * 	查询所有
	 *	@author 	GFF
	 *	@date		2017年3月21日下午2:37:06	
	 * 	@return
	 */
	public List<T> selectAll();
	
	/**
	 * 	根据主键查询
	 *	@author 	GFF
	 *	@date		2017年3月21日下午2:37:22	
	 * 	@param id
	 * 	@return
	 */
	public T selectByPrimaryKey(ID id);
	
	/**
	 * 	新增
	 *	@author 	GFF
	 *	@date		2017年3月21日下午2:37:33	
	 * 	@param record
	 * 	@return
	 */
	public int insert(T record);
	
	/**
	 * 	新增（排除null值）
	 *	@author 	GFF
	 *	@date		2017年3月21日下午2:37:53	
	 * 	@param record
	 * 	@return
	 */
	public int insertSelective(T record);
	
	/**
	 * 	新增(返回主键id)
	 *	@author 	GFF
	 *	@date		2017年3月21日下午2:38:12	
	 * 	@param record
	 * 	@return
	 */
	public int insertUseGeneratedKeys(T record);
	
	/**
	 * 	根据主键更新
	 *	@author 	GFF
	 *	@date		2017年3月21日下午2:55:59	
	 * 	@param record
	 * 	@return
	 */
	public int updateByPrimaryKey(T record);
	
	/**
	 * 	根据主键更新（排除null值）
	 *	@author 	GFF
	 *	@date		2017年3月21日下午2:56:16	
	 * 	@param record
	 * 	@return
	 */
	public int updateByPrimaryKeySelective(T record);
	
	/**
	 * 	根据example更新
	 *	@author 	GFF
	 *	@date		2017年3月21日下午2:56:47	
	 * 	@param record
	 * 	@param example
	 * 	@return
	 */
	public int updateByExample(T record, Example example);
	
	/**
	 * 	根据example更新（排除null值）
	 *	@author 	GFF
	 *	@date		2017年3月21日下午2:57:15	
	 * 	@param record
	 * 	@param example
	 * 	@return
	 */
	public int updateByExampleSelective(T record,Example example);
	
	/**
	 * 	根据example删除
	 *	@author 	GFF
	 *	@date		2017年3月22日下午2:23:06	
	 * 	@param 		example
	 */
	public int deleteByExample(Example example);
	
	/**
	 *	根据条件删除 
	 *	@author 	GFF
	 *	@date		2017年4月10日下午3:59:26	
	 * 	@param record
	 * 	@return
	 */
	public int  delete(T record);
	
	/**
	 * 	根据id删除
	 *	@author 	GFF
	 *	@date		2017年4月10日下午3:59:45	
	 * 	@param id
	 * 	@return
	 */
	public int  deleteByPrimaryKey(ID id);
	
	/**
	 * 	查询最后的number编号
	 *	@author 	GFF
	 *	@date		2017年4月10日下午4:00:40	
	 * 	@param t
	 * 	@return
	 */
	public String selectEndNumber();
	
	/**
	 *  查询所有未删除的结果集
	 *	@author 	GFF
	 *	@date		2017年4月10日下午4:20:21	
	 * 	@return
	 */
	public List<T> selectNotDeleteALL();
	
	/**
	 * 	根据id删除数据(逻辑删除)
	 *	@author 	GFF
	 *	@date		2017年4月10日下午4:22:05	
	 * 	@param id
	 * 	@return
	 */
	int deleteByPrimaryKeyToLogic(ID id);

	/**
	 * 	批量插入
	 *	@author 	GFF
	 *	@date		2017年7月5日上午9:06:46	
	 * 	@param t
	 * 	@return
	 */
	public int insertList(List<T> t);

	}
