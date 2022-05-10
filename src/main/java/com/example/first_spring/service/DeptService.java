package com.example.first_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.first_spring.mapper.DeptMapper;
import com.example.first_spring.vo.DeptVO;

@Service
public class DeptService {
	
	@Autowired
	private DeptMapper deptMapper;
	
	
	public List<DeptVO> getDeptList(){
		return deptMapper.getDeptList();
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int updateDept(DeptVO deptvo) {
		int rows = deptMapper.updateDept(deptvo);
		return rows;
		
	}
	
	public int deleteDept(int deptno) {
		int rows = deptMapper.deleteDept(deptno);
		return rows;
	}

}
