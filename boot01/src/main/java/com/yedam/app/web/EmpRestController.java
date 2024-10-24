package com.yedam.app.web;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

//@Controller
@RestController
public class EmpRestController {
	private EmpService empService;
	
	public EmpRestController(EmpService empService) {
		this.empService = empService;
	}
	/*
	@GetMapping("empList")
	public String empList(Model model) {
		List<EmpVO> list = empService.empList();
		model.addAttribute("emps", list);
		return "emp/List";
	}
	*/
	
	// 전체조회
	@GetMapping("emps")
	//@ResponseBody	// AJAX => 모델 사용 X
	public List<EmpVO> empList() {
		return empService.empList();
	}
	
	
	
	// 단건 조회
	@GetMapping("emps/{employeeId}")
	//@ResponseBody
	public EmpVO empInfo(@PathVariable Integer employeeId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		return empService.empInfo(empVO);
	}
	
	
	
	// 등록: POST
	@PostMapping("emps")	// @RequestBody : JSON
	public int empInsert(@RequestBody EmpVO empVO) {
		return empService.empInsert(empVO);	
	}
	
	
	
	// 수정: PUT (= POST) => 전체 데이터
	@PutMapping("emps/{employeeId}")
	public Map<String, Object> empUpdate(@PathVariable Integer employeeId, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(employeeId);
		return empService.empUpdate(empVO);
	}
	
	
	// 삭제: DELETE (= GET)
	@DeleteMapping("emps/{employeeId}")
	public Map<String, Object> empDelete(@PathVariable Integer employeeId) {
		return empService.empDelete(employeeId);
	}
	
	
	
	
	
}

/*
//==========================================================
//== RESTful 웹 구성하기
  [설명] REST는 무엇인가?
  - AJAX + JSON + 다양한 클라이언트(모바일, 네비게이션, 가전제품 등...)의 등장 => REST (새로운 형태의 서버)
 	1) 페이지 없이 순수 데이터만 제공
 	2) EndPoint(URI + Method)를 구성하는 새로운 방식
 		URI(자원만 표기) + Method(GET, POST, PUT, DELETE / 기능을 의미)
 		
 
	[4-1] 기존 전통 방식의 통신을 사용하지 않고 REST하게. 즉, 화면 구성을 하지 않고 데이터만 JSON 형식으로 보내자.
	
	[4-2] REST 방식은 Path Variable 형식을 중점적으로 사용함. URI에서 특정 값을 가져오려면 우선
		@GetMapping() 안에서 {}을 사용한 후, 메소드의 매개변수에 @PathVariable 어노테이션을 지정함.











*/