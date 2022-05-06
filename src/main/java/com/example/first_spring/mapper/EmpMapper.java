package com.example.first_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.first_spring.vo.EmpVO;

/**
 * @author dw-014
 * comment : emp테이블 전체사원 조회
 */
@Mapper
public interface EmpMapper {
	
	public List<EmpVO> getEmpList();
	
	public EmpVO getEmp(int empNo);
	
	public List<EmpVO> getLList();
	
	public List<EmpVO> getCommNullList();
	
	public List<EmpVO> getHiredate();

	public List<EmpVO> getDeptSalList(int sal);
	
	public List<EmpVO> getMGRnullList();
	
	public List<EmpVO> get1987hireList(int year);
	
	public List<EmpVO> getMaxSalEmpno(int month);
	
	public EmpVO getFastEmpList(String job);
	
	public List<EmpVO> getJobManager(
			@Param("job") String job,
			@Param("sal") int sal);
	}
	
