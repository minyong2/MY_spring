package com.example.first_spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.first_spring.mapper.EmpMapper;
import com.example.first_spring.vo.EmpVO;

@Service
public class EmpService {
	
	@Autowired
	private EmpMapper empMapper;

	
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
	
	//job이 manager고 sal이 2500이상인 사원 comm 500으로 업데이트
	@Transactional(rollbackFor = Exception.class)
	public List<EmpVO> getJobManager(String job, int sal) {
		int comm = 500; //commition
		int rows = 0;
			List<EmpVO> list = empMapper.getJobManager(job, sal);
			for(int i=0; i<list.size(); i++) {
				list.get(i).setComm(comm);
				EmpVO vo = list.get(i);
				vo.setComm(comm);
				rows += empMapper.updateEmp(vo);
			}
			if(rows > 0) {
				return empMapper.getJobManager(job, sal);
				
			}
		return null;
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
	
	@Transactional(rollbackFor = {Exception.class})
	public int setEmp(EmpVO vo) {
	
//		EmpVO empVO = empMapper.selectDeptNo();
//		int deptNo = empVO.getDeptno();
//		vo.setDeptno(deptNo);
//		
		//몇행 insert가 되었는지 리턴
		int rows = empMapper.inserEmp(vo); 
		return rows;
	} 
	
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpRemoveCount(int empno) {
		List<EmpVO> list = new ArrayList<EmpVO>();
	
		int rows = empMapper.deleteEmp(empno);
		//몇행 delete가 되었는지 리턴
		return rows;
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpUpdateCount(EmpVO vo) {
		int rows = empMapper.updateEmp(vo);
		//몇행 update가 되었는지 리턴
//		UserVO user = null;
//		String name = user.getName();
//		System.out.println(name);
		return rows;
	}
	
	public int getCountNameA(String ename){
		List<EmpVO> list = empMapper.getCountNameA(ename);
			
		return list.size();
		}
	
	public List<EmpVO> getEmpMgr(String isMgr){
		return empMapper.selectEmpMgr(isMgr);
	}

	public int updateTest1(EmpVO vo) {
		return empMapper.updateTest1(vo);
	}
	
	public int getEmpUpdateCommSal(int empno) {
		//COMM이 0혹은 null이면
		EmpVO vo = empMapper.selectEmpCommSal(empno);
		int comm = vo.getComm();
		if(comm == 0) {
			int bonus = 500;
			int sal = vo.getSal();
			vo.setSal(sal+bonus);
			return empMapper.updateEmpSal(vo);
		}
		return 0;
	}
	
	public List<Map<String,Object>> getEmpMapList(){
		return empMapper.selectEmpMapList();
	}
	
	public int getDelete(int empno) {
		return empMapper.getDelete(empno);
	}
	
	public int getApi(int empno,EmpVO empvo) {
		empvo.setEmpno(empno);
		return empMapper.updateTest1(empvo);
	}
}
