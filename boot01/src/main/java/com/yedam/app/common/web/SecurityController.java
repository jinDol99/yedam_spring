package com.yedam.app.common.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.security.service.LoginVO;

@Controller
public class SecurityController {
	@GetMapping("all")
	public void all() {}	
	
	@GetMapping("user")
	public void user(@AuthenticationPrincipal UserDetails userDetails) {
		LoginVO loginVO = (LoginVO) userDetails;
		log.error(loginVO.getUserVO().toString());	// 간단하게 현재 로그인된 사용자 정보를 출력하는 두 가지 방법
	}	
	
	@GetMapping("admin")
	public void admin(@AuthenticationPrincipal LoginVO loginVO) {
		log.error(loginVO.getUserVO().toString());
	}
	
}
