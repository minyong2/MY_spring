package com.example.first_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.first_spring.vo.DeptVO;
import com.example.first_spring.vo.EmpVO;

/**
 * @author dw-014
 * comment : emp테이블 전체사원 조회
 */
@Mapper
public interface MainMapper {
	
	public List<EmpVO> getEmpList();
	
	public EmpVO getEmp();
	
	public List<DeptVO> getDeptList();

}
