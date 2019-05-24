package com.dhr.domain;

import java.io.Serializable;

/**
 * 课程类型
 * 
 * @author Mr DU
 *
 */
public class ClassType implements Serializable {
	private Integer id;
	private String name;
	private String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
