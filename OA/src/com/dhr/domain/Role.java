package com.dhr.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色
 * 
 * @author Mr DU
 *
 */
public class Role implements Serializable {
	private Integer id;
	private String name;
	private String description;

	private List<Function> functions = new ArrayList<Function>();

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

	public List<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

}
