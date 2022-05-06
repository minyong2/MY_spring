package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.EmpService;
import com.example.first_spring.vo.EmpVO;

@RestController
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@GetMapping("/emp")
	public List<EmpVO> callEmpList(){
		
		return empService.getAllempList();
	}
	
	@GetMapping("/emp/no/{empNo}")
	public EmpVO callEmp(@PathVariable("empNo") int empNo) {
		return empService.getEmp(empNo);
	}
	
	@GetMapping("/emp/name")
	public List<EmpVO> callLList(){
		return empService.getLList();
	}
	
	@GetMapping("/emp/comm")
	public List<EmpVO> callCommNullList(){
		
		return empService.getCommNullList();
	}
	@GetMapping("/emp/hiredate")
	public List<EmpVO> callHiredate(){
		
		return empService.getHireate();
	}
	
	@GetMapping("/emp/job/{job}/sal/{sal}")
	public List<EmpVO> callJobManager(
			@PathVariable("job") String job ,
			@PathVariable("sal") int sal) {
		return empService.getJobManager(job,sal);
	}
	
	//문제 0. 급여 1500을 파라미터로 받고 
	//부서가 10, 30에 속하는 사원 중 급여가 1500을 넘는 사원의 이름 및 급여 조회.
	@GetMapping("/emp/sal/{sal}")
	public List<EmpVO> callDeptSalList(@PathVariable("sal") int sal){
		
		return empService.getDeptSalList(sal);
	}
	
	//문제 1. emp에서 사수가 없는 사원 조회
	@GetMapping("/emp/mgr")
	public List<EmpVO> callMGRnullList(){
		return empService.getMGRnullList();
	}
	
	//문제 2. 1987년도를 파리미터로 받고 해당 년도에 입사한 사원 조회 
	@GetMapping("/emp/hiredate/year/{year}")
	public List<EmpVO> call1987hireList(@PathVariable("year") int year){
		
		return empService.get1987hireList(year);
	}
	
	//문제 3. 12월을 파라미터로 받고 해당 월에 입사한 사원 중 급여가 가장 많은 사원 조회
	@GetMapping("/emp/hiredate/month/{month}")
	public List<EmpVO> callMaxSalEmpno(@PathVariable("month") int month){
		return empService.getMaxSalEmpno(month);
	}
	
	//문제 4. MANAGER를 파라미터로 받고 job이 MANAGER 중 입사날짜가 가장 빠른 사원의 이름, 입사날짜, 급여 조회 
	@GetMapping("/emp/job/{jobName}")
	public EmpVO callFastEmpList(@PathVariable("job") String job) {
		return empService.getFastEmpList(job);
	}
	
	
	

}
