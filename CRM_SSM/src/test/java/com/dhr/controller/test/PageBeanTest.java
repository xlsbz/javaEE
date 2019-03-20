package com.dhr.controller.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.portlet.MockActionRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dhr.domain.Emp;
import com.github.pagehelper.PageInfo;

/**
 * 测试分页
 * @author Mr DU
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:spring/applicationContext.xml","classpath:spring/springmvc.xml"})
public class PageBeanTest {

	//传入springmvc
	@Autowired
    WebApplicationContext context;
	
	//虚拟请求，获得结果
	MockMvc mvc;
	
	@Before
	/**
	 * 初始化工作
	 */
	public void initMockMvc() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPageBean() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/emps").param("pageNumber", "2")).andReturn();
		//请求成功后，页面的域里就会有数据
		MockHttpServletRequest request = result.getRequest();
		PageInfo<Emp> pageBean = (PageInfo<Emp>) request.getAttribute("pageBean");
		//测试输出
		System.out.println("当前页码："+pageBean.getPageNum());
		System.out.println("总页码："+pageBean.getPages());
		System.out.println("总记录数："+pageBean.getTotal());
		System.out.println("连续显示的页码：");
		int[] pages = pageBean.getNavigatepageNums();
		for (int i : pages) {
			System.out.print(i+" ");
		}
		
		//每页数据
		List<Emp> list = pageBean.getList();
		for (Emp emp : list) {
			System.out.println(emp.getEmpName()+" "+emp.getDept().getDeptName());
		}
	}
	
	
	
	
}
