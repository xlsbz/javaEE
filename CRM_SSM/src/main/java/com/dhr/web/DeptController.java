package com.dhr.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhr.domain.Dept;
import com.dhr.domain.Msg;
import com.dhr.service.IDeptService;

/**
 * 部门管理
 * @author Mr DU
 *
 */
@Controller
public class DeptController {

	//注入部门service
	@Autowired
	private IDeptService deptService;
	
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getAllDept() {
		//查询所有部门信息
		List<Dept> dept = deptService.getAllDepts();
		//封装参数
		return Msg.success().add("depts", dept);
	}
}
