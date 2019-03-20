package com.dhr.service;

import java.util.List;


import com.dhr.domain.Emp;
public interface IEmpService {

	List<Emp> getAllEmp();

	Integer addEmp(Emp emp);

	void delEmpId(Integer empId);

	boolean checkUser(String empName);

	Emp getEmpId(Integer empId);

	void updateEmp(Emp emp);

	void delEmpids(List<Integer> empList);

}
