package com.example.first_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_spring.mapper.HomeMapper;
import com.example.first_spring.vo.EmpVO;

@Service
public class HomeService {
	
	@Autowired
	private HomeMapper homeMapper;
	
	public List<EmpVO> getEnameSal(){	
		return homeMapper.getEnameSal();
	}
	
	public List<EmpVO> getMgrNullEmpno(){
		return homeMapper.getMgrNullEmpno();
	}
	
	public List<EmpVO> getHiredateEmpno(int year){
		if(homeMapper.getHiredateEmpno(year).size()<=3) {
			return homeMapper.getHiredateEmpno(1981);
		}
		return homeMapper.getHiredateEmpno(year);
	}
	
	public List<EmpVO> getDecTopSal(int month) {
		int max = 0;
		
		
		return homeMapper.getDecTopSal(month);
	}
	
	public List<EmpVO> selectJobManager(){
		return homeMapper.selectJobManager();
		}

}
