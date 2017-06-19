package com.pj.flow.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *	@author		GFF
 *	@date		2017年6月19日上午11:49:11
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Table(name="flow_application_type")
public class FlowApplicationType {

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
	
	@Column
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
