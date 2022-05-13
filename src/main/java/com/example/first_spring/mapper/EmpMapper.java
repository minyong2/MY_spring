package com.example.first_spring.mapper;

import java.util.List;
import java.util.Map;

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
			@Param("sal") int sal
			);
	
	
	public int deleteEmp(int empno); //데이터 삭제
	public int updateEmp(EmpVO empvo); //emp데이터 수정
	public int inserEmp(EmpVO empvo); //데이터 삽입v
	
	public EmpVO selectDeptNo();//v
	
	public List<EmpVO> getCountNameA(String ename);
	
	public List<EmpVO> selectEmpMgr(@Param("isMgr") String isMgr);
	
	public int updateTest1(EmpVO vo);
	
	public EmpVO selectEmpNo();
	
	public EmpVO selectEmpCommSal(@Param("empno") int empno);
	//empno 조회하는거라 EmpVO ! EmpVO는 PK니까!
	
	public int updateEmpSal(EmpVO vo);
	
	public List<Map<String,Object>> selectEmpMapList();
	
	public int getDelete(int empno);
	
	
	
	
	
	
	}

	
