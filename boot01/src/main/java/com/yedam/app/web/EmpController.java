package com.yedam.app.web;

import org.springframework.stereotype.Controller;

import com.yedam.app.emp.service.EmpService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmpController {
	private final EmpService empService;
}

/*
	[2-13] View에게 값을 전달하는 Controller을 만들자.
		@Controller 어노테이션은 당연히 추가하고, @RequiredArgsConstructor 어노테이션을 추가하면
		좀 더 편하게 DI 및 생성자 주입이 가능함.







*/