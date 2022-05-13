package com.example.first_spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.EmpService;
import com.example.first_spring.vo.EmpVO;

@RestController
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@CrossOrigin(origins = {"*"})
	@GetMapping("/emp")
	public List<EmpVO> callEmpList(){
		
		return empService.getAllempList();
	}
	
	@GetMapping("/emp/no/{empNo}")
	public EmpVO callEmp(@PathVariable("empNo") int empNo) {
		return empService.getEmp(empNo);
	}
	
//	@GetMapping("/emp/name")
//	public List<EmpVO> callLList(){
//		return empService.getLList();
//	}
	
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

	
	//emp테이블에 insert 해보기
	//@RequestBody가 파라미터로 넘어오는 VO를 대신 new 해줌
	@CrossOrigin(origins = {"*"})
	@PostMapping("/emp")
	public int callEmpSet(@RequestBody EmpVO empvo) {
//		System.out.println("사원 이름은 : " + empvo.getEname());
//		System.out.println("사원 번호는 : " + empvo.getEmpno());
//		System.out.println("사원 직업은 : " + empvo.getJob());
		return empService.setEmp(empvo);
	}
	
	//@DeleteMapping : 데이터 삭제 시 사용
	@CrossOrigin(origins = {"*"})
	@DeleteMapping("/emp/empno/{empno}")
	public int callEmpRemove(@PathVariable("empno") int empno) {
		
		return empService.getEmpRemoveCount(empno);
	}
	
	//	@PatchMapping : 자원 수정할 때 사용
	@PatchMapping("/emp")
	public int callEmpUpdate(@RequestBody EmpVO empvo) {
		
		return empService.getEmpUpdateCount(empvo);
	}
	//쿼리스트링으로 getmapping
	//tire?region=kr
	//검색할 때 많이 사용
	@GetMapping("/tier")
	public String callTier(
			@RequestParam("region") String region
			,@RequestParam("name") String name) {
		return region+","+name;
	}
	
	//board?page=1&pageSize=10&writer=김민영
	//쿼리에서 pageSize는 limit으로 가능
	//but 데이터수가 너무많을때(ex 1억) between을 써야 함
	@GetMapping("/board") 
	public int callBoard(@RequestParam("page") int page,
			@RequestParam("pageSize") int pageSize,
			@RequestParam("writer") String writer) {
		System.out.println("현재 페이지는"+page);
		System.out.println("한 페이지에 보여주는 row 수는 " + pageSize);
		System.out.println("작성자는 "+writer);
		return 0;
	}
	
	@GetMapping("/emp/name")
	public int callgetCountNameA(
			@RequestParam("search") String search ){
		return empService.getCountNameA(search);
	}
	
	@GetMapping("/emp/mgr/{isMgr}")
	public List<EmpVO> callEmpMgr(@PathVariable("isMgr") String isMgr){
		
		return empService.getEmpMgr(isMgr);
	}
	
	@CrossOrigin(origins = {"*"})
	@PatchMapping("/emp/{empno}")
	public int updateTest1(@RequestBody EmpVO vo, @PathVariable("empno") int empno) {
		return empService.updateTest1(vo);
	}
	
	
	@PatchMapping("/emp/empno/{empno}")
	public int callEmpSalUpdate(@PathVariable("empno") int empno) {
		
		return empService.getEmpUpdateCommSal(empno);
		
	}
	@GetMapping("/emp/map/list")
	public List<Map<String,Object>> callEmpMap(){
		return empService.getEmpMapList();
	}
	
	@CrossOrigin(origins = {"*"})
	@DeleteMapping("/emp/delete/{empno}")
public int callDelete(@PathVariable("empno") int empno) {
		
		return empService.getDelete(empno);
	}
	
	@CrossOrigin(origins = {"*"})
	@PatchMapping("/api/v1/list/{empno}")
	public int callApi(@PathVariable("empno") int empno, @RequestBody EmpVO empvo) {
		return empService.getApi(empno, empvo);
	}
	
	
	
	
}
