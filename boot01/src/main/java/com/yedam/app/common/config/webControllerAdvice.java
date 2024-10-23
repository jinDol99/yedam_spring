package com.yedam.app.common.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class webControllerAdvice {
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException e) {
		return "error/notFound";
	}
	
	@ModelAttribute("contextPath")
	public String contextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
}

/*
	[2-18] 브라우저(톰캣)에서 여러 오류가 발생하면 404, 400, 401 등의 여러 오류코드를
		아주 상세히 출력해줌. 해커 입장에서는 아주 좋은 먹잇감 헤헿
		이렇게 여러 곳에 흩뿌려져있는 에러코드들을 한 곳에 모아 관리를 하고
		실 사용자에게 모호한 오류코드를 뿌려져 보안에 이점이 있는 특징이 있음
		
		






*/