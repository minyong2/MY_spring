package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.DeptService;
import com.example.first_spring.vo.DeptVO;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@GetMapping("/dept")
	public List<DeptVO> callDeptList(){
		
		return deptService.getDeptList();
	}
	
	@PatchMapping("/dept")
	public int updateDept(@RequestBody DeptVO deptvo) {
		
		return deptService.updateDept(deptvo);
	}
	
	@DeleteMapping("/dept/deptno/{deptno}")
	public int deleteDept(@PathVariable("deptno") int deptno) {
		
		return deptService.deleteDept(deptno);
	}
}
