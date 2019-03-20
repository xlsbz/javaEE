package com.dhr.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhr.domain.Emp;
import com.dhr.domain.Msg;
import com.dhr.service.IEmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 员工信息web层
 * @author Mr DU
 *
 */
@Controller
public class EmpController {

	//注入service
	@Autowired
	private IEmpService empService;
	
	@RequestMapping("/emps")
	/**
	 * 分页查询所有员工信息
	 * @return
	 */
	public String getAllEmp(@RequestParam(value= "pageNumber",defaultValue="1") Integer pageNumber,Model model) {
		//1.获取页面传来的当前页
		//使用pageHelper
		PageHelper.startPage(pageNumber, 8);
		//2.调用service查询
		List<Emp> emps = empService.getAllEmp();
		//3.封装数据
		PageInfo<Emp> pageInfo = new PageInfo<>(emps);
		model.addAttribute("pageBean", pageInfo);
		return "list";
	}
	
	/**
	 * 根据ID查询用户信息
	 * @return
	 */
	@RequestMapping(value="/getEmpId/{empId}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getEmpId(@PathVariable Integer empId) {
		Emp emp = empService.getEmpId(empId);
		return Msg.success().add("emp", emp);
	}
	
	/**
	 * Ajax分页
	 * @return
	 */
	@RequestMapping("/empAjax")
	@ResponseBody
	public Msg getAllEmpAjax(@RequestParam(value="pageNumber",defaultValue="1")int pageNumber,Model model) {
		//引用PageHelper分页组件  开始页
		PageHelper.startPage(pageNumber, 6);
		List<Emp> emp = empService.getAllEmp();
		//把查询出来的结果集直接放入pageInfo中
		PageInfo<Emp> pageInfo = new PageInfo<>(emp);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	/****
	 * 保存数据
	 * JSR303校验
	 * @param emp
	 * @return
	 */
	@RequestMapping(value="/addEmp",method=RequestMethod.POST)
	@ResponseBody
	public Msg addEmp(@Valid Emp emp,BindingResult result) {
		//调用service保存数据
		if(result.hasErrors()) {
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
//				System.out.println("错误的字段"+fieldError.getField());
//				System.out.println("错误的提示"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.error().add("errorFields",map);
		}else {
			empService.addEmp(emp);
			return Msg.success().add("msg", "信息保存成功！");
		}
	}
	
	/**
	 * 使用restful风格
	 * 单个删除   批量删除
	 * @return
	 */
	@RequestMapping(value="/delEmpId/{empIds}",method=RequestMethod.DELETE)
	@ResponseBody
	public Msg delEmpId(@PathVariable String empIds) {
		//判断是一个还是多个
		if(!empIds.contains("-")) {
			//删除单个
			empService.delEmpId(Integer.parseInt(empIds));
		}else {
			//删除多个
			//拆分字符串
			String[] ids = empIds.split("-");
			//转换为集合
			List<Integer> empList = new ArrayList<>();
			for(int i=0;i<ids.length;i++) {
				empList.add(Integer.parseInt(ids[i]));
			}
			empService.delEmpids(empList);
			
		}
		
		Msg msg = new Msg();
		msg.setMsg("信息删除成功!");
		msg.setCode(1);
		return msg;
	}
	/**
	 * 检查用户名是否可用
	 * @return
	 */
	@RequestMapping("/checkUser")
	@ResponseBody
	public Msg checkUser(String empName) {
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!empName.matches(regx)) {
			return Msg.error().add("vs_msg", "后台提示：用户名必须是2-16个字母或者3-5个中文");
		}
		boolean flag = empService.checkUser(empName);
		if(flag) {
			//可以注册
			return Msg.success();
		}
		return Msg.error();
	}
	
	
	/**
	 * 更新数据：put--->需要配置一个过滤器HttpPutFormContentFilter
	 * @return
	 */
	@RequestMapping(value="/updateEmp/{empId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg updateEmp(Emp emp) {
		empService.updateEmp(emp);
		return Msg.success();
	}
}
