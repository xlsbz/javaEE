package com.dhr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhr.domain.Emp;
import com.dhr.domain.EmpExample;
import com.dhr.domain.EmpExample.Criteria;
import com.dhr.mapper.EmpMapper;
import com.dhr.service.IEmpService;
@Service
public class EmpServiceImpl implements IEmpService{

	//注入Dao
	@Autowired
	private EmpMapper empMapper;
	
	@Override
	public List<Emp> getAllEmp() {
		return empMapper.SelelctByEmpWithDept();
	}

	@Override
	public Integer addEmp(Emp emp) {
		int i = empMapper.insertSelective(emp);
		return i;
	}

	@Override
	public void delEmpId(Integer empId) {
		empMapper.deleteByPrimaryKey(empId);
	}

	@Override
	public boolean checkUser(String empName) {
		EmpExample example = new EmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		List<Emp> emp = empMapper.selectByExample(example);
		if(emp.size()>0) {
			return false;
		}
		return true;
	}

	@Override
	public Emp getEmpId(Integer empId) {
		Emp emp = empMapper.selectByPrimaryKey(empId);
		return emp;
	}

	@Override
	public void updateEmp(Emp emp) {
		empMapper.updateByPrimaryKeySelective(emp);
	}

	@Override
	public void delEmpids(List<Integer> empList) {
		EmpExample example = new EmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdIn(empList);
		empMapper.deleteByExample(example);
	}

}
