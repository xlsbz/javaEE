package com.dhr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhr.domain.Dept;
import com.dhr.mapper.DeptMapper;
import com.dhr.service.IDeptService;
@Service
public class DeptServiceImpl implements IDeptService {
	
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public List<Dept> getAllDepts() {
		return deptMapper.selectByExample(null);
	}

	
}
