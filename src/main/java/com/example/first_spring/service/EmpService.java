package com.example.first_spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_spring.mapper.EmpMapper;
import com.example.first_spring.vo.EmpVO;

@Service
public class EmpService {
	
	@Autowired
	private EmpMapper empMapper;
	List<EmpVO> list = new ArrayList<EmpVO>();
	
	public List<EmpVO> getAllempList(){
		
		return empMapper.getEmpList();
	}
	
	public EmpVO getEmp(int empNo) {
		return empMapper.getEmp(empNo);
	}
	
	public List<EmpVO> getLList(){
		
		return empMapper.getLList();
	}
	
	public List<EmpVO> getCommNullList(){
		
		return empMapper.getCommNullList();
	}
	
	public List<EmpVO> getHireate(){
		
		return empMapper.getHiredate();
	}
	
	public List<EmpVO> getJobManager(String job, int sal) {
			if(job.equals("SALESMAN")) {
				return null;
			}
		return empMapper.getJobManager(job, sal);
	}
	
	public List<EmpVO> getDeptSalList(int sal){
		
			if(sal > sal) {
				
			}
		
		
		return empMapper.getDeptSalList(sal);
	}
	
	public List<EmpVO> getMGRnullList(){
		
		return empMapper.getMGRnullList();
	}
	
	//문제 2. 1987년도를 파리미터로 받고 해당 년도에 입사한 사원 조회
	public List<EmpVO> get1987hireList(int year){
		
		return empMapper.get1987hireList(year);
	}
	
	//문제 3. 12월을 파라미터로 받고 해당 월에 입사한 사원 중 급여가 가장 많은 사원 조회
	public List<EmpVO> getMaxSalEmpno(int month) {
	
		return empMapper.getMaxSalEmpno(month);
	}
	
	//문제 4. MANAGER를 파라미터로 받고 job이 MANAGER 중 
	//입사날짜가 가장 빠른 사원의 이름, 입사날짜, 급여 조회
	public EmpVO getFastEmpList(String job) {

		return empMapper.getFastEmpList(job);
	}

}
