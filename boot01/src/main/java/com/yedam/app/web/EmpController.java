package com.yedam.app.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor		// 생성자 주입의 변경 여부를 고려.
								// => 추가 생성자 X
public class EmpController {
	// 제공하고자 하는 서비스
	private final EmpService empService;
	
	// GET: 조회, 빈페이지
	// POST: 데이터 조작(등록, 수정, 삭제)
	//== 전체조회: GET  ==//
	@GetMapping("empList")		// 사용자의 요청(URI + METHOD)
	public String empList(Model model) {
		//기능 수행
		List<EmpVO> list = empService.empList();
		
		// => 페이지에 전달할 데이터 담기
		model.addAttribute("emps", list);
		
		return "emp/list";	// 데이터를 출력할 페이지 링크
		// classpath:/templates/emp/list.html
	}
	
	
	
	//== 단건조회: GET => employeeId (QueryString + 객체 방식인 "커맨드 객체"로 파라미터를 받음)  ==//
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
						// 커맨드 객체 : 객체 + 어노테이션
		EmpVO findVO = empService.empInfo(empVO);
		
		model.addAttribute("emp", findVO);
		
		return "emp/info";
	}
	
	
	
	//== 등록 - 페이지 : GET  ==//
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	
	
	
	//== 등록 - 처리 : POST => HTML의 <form/> 태그 + submit  ->  QueryString + 객체 / 커맨드 객체  ==//
	@PostMapping("empInsert")	// 등록 페이지와 같은 기능이기 때문에 매핑 URI는 공유함.
	public String empInsertProcess(EmpVO empVO) {
		int result = empService.empInsert(empVO);
		
		String url = null;
		if(result > 0) {
			// 정상 등록
			url = "redirect:empList";
		} else {
			// 등록되지 않음 경우 -> 새로고침
			url = "redirect:empInsert";
		}
		
		return url;
	}
	
	
	
	//== 수정 - 페이지 : GET = 단건조회  ==//
	@GetMapping("empUpdate")
	public String empUpdate(EmpVO empVO, Model model) {
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("emp", findVO);
		return "emp/update";
	}	
	
	
	
	//== 수정 - 처리 : POST ==//
	// 1) AJAX => QueryString
	@PostMapping("empUpdate")
	@ResponseBody	// AJAX를 처리할 경우 반드시 @ResponseBody 사용해야 함
					// AJAX는 페이지를 사용하지 않고 데이터만 주고받으니 Model 객체와 페이지 리턴 필요 X
	public Map<String, Object> empUpdateAJAXQueryString (EmpVO empVO) {
		return empService.empUpdate(empVO);
	}
	
	// 2) AJAX => JSON (@RequestBody)
	//@PostMapping("empUpdate")
	@ResponseBody
	public Map<String, Object> empUpdateAJAXJSON (@RequestBody EmpVO empVO) {
		return empService.empUpdate(empVO);
	}
	
	
	
	//== 삭제: GET => QueryString + 단일값 -> @RequestParam  ==//
	@GetMapping("empDelete")
	public String empDelete(Integer empId) {
		empService.empDelete(empId);
		return "redirect:empList";
	}
}

/*
	[2-13] View에게 값을 전달하는 Controller을 만들자.
		@Controller 어노테이션은 당연히 추가하고, @RequiredArgsConstructor 어노테이션을 추가하면
		좀 더 편하게 DI 및 생성자 주입이 가능함.
		단, 해당 어노테이션은 생성자가 단 한개만 있을 경우에만 사용 가능함.


	
	[2-14] 전통적인 방식으로 7개의 매핑(전체조회, 단건조회, 등록 2건, 수정 2건, 삭제)을 하자.
		매핑을 할 때는 기본 골격은 아래와 같음
	
	@GetMapping("")							// 사용자의 요청(URI)과 방식(Method) 처리
	public String empList(Model model) {
		return "";							// 기능을 수행한 후 데이터를 출력할 페이지 링크
	}
	
		이 때 세션을 이용해 작업할 것이 있거나 리퀘스트를 직접 건들여야하는 필요가 있는 경우
		`empList(Model model) 부분에서 매개변수를 관련 session 이나 request로 변경하여 작성하면 됨
		
	



*/