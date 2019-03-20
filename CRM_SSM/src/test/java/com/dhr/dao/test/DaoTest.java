package com.dhr.dao.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dhr.domain.Dept;
import com.dhr.domain.Emp;
import com.dhr.mapper.DeptMapper;
import com.dhr.mapper.EmpMapper;

/**
 * 测试Dao
 * @author Mr DU
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/applicationContext.xml"})
public class DaoTest {

	//注入属性文件
	@Autowired
	private DeptMapper deptMapper;
	
	@Autowired
	private EmpMapper empMapper;
	
	@Test
	public void demo1() {
		//测试mapper程序
		//增加信息
		Dept dept = new Dept();
		dept.setDeptName("公关部");
		deptMapper.insertSelective(dept);
		
		//增加信息
//		Emp emp = new Emp();
//		emp.setEmpName("王芳");
//		emp.setGender("女");
//		emp.setEmail("222@qq.com");
//		emp.setdId(1);
//		empMapper.insertSelective(emp);
		
		//级联查询信息
//	    List<Emp> emp = empMapper.SelelctByEmpWithDept();
//		for (Emp e : emp) {
//			System.out.println(e.toString()+" "+e.getDept().toString());
//		}
		
		//批量插入数据
//		Emp emp = null;
//		for(int i=0;i<500;i++) {
//			emp = new Emp();
//			emp.setEmpName("王芳"+i);
//			emp.setGender("女");
//			emp.setEmail(i+"222@qq.com");
//			emp.setdId(1);
//			empMapper.insertSelective(emp);
//		}
	}
}
