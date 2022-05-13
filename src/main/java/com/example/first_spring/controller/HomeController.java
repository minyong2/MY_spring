package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.HomeService;
import com.example.first_spring.vo.EmpVO;

@RestController
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	//0번 ====================================
	@GetMapping("/homework")
	public List<EmpVO> callEnameSal(){
		return homeService.getEnameSal();
	}
	//1번 ====================================
	@GetMapping("/homework/mgr")
	public List<EmpVO> callMgrNullEmpno(){
		return homeService.getMgrNullEmpno();
	}
	
	//2번 ====================================
	@GetMapping("/homework/hiredate/year/{year}")
public List<EmpVO> getHiredateEmpno(@PathVariable("year") int year){
		
		return homeService.getHiredateEmpno(year);
	}
	
	
}
