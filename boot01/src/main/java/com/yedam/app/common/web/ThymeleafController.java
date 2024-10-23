package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class ThymeleafController {
	private EmpService empService;
	
	public ThymeleafController(EmpService empService) {
		this.empService = empService;
	}
	
	@GetMapping("firstPage")
	public String firstPage() {
		return "thymeleaf/first";
		// prefix => classpath:/templates/
		// subfix => .html
		// classPath: /templates/thymeleaf/first.html
	}
	
	@GetMapping("secondPage")
	public String secondPage(Model model) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("info", findVO);
		return "thymeleaf/second";	//classpath:/templates/templates/second.html
	}
}

/* =========================
   == 타임리프 실습

	[3-1] 타임리프 HTML과 매핑하기 위해 전용 Controller을 만들어주자.



=*/