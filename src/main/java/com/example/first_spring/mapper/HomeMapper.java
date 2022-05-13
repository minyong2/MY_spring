package com.example.first_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.first_spring.vo.EmpVO;

@Mapper
public interface HomeMapper {
	
	//문제 0. 급여 1500을 파라미터로 받고 부서가 
	//		10, 30에 속하는 사원 중 급여가 1500을 넘는 사원의 이름 및 급여 조회.
	public List<EmpVO> getEnameSal();
	
	//문제 1. emp에서 사수가 없는 사원 조회
	public List<EmpVO> getMgrNullEmpno();

	
	//문제 2. 1987년도를 파리미터로 받고 해당 년도에 입사한 사원 조회 
	public List<EmpVO> getHiredateEmpno(int year);
	
	//문제 3. 12월를 파라미터로 받고 해당 월에 입사한 사원 중 급여가 가장 많은 사원 조회
	public List<EmpVO> getDecTopSal(int month);
}
