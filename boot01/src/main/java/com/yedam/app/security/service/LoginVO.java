package com.yedam.app.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor		// Setter로 하면 로그인 정보 자체가 변경될 여지가 있으므로 @Data 어노테이션이 아닌
@Getter							// @RequiredArgsConstructor과 @Getter 어노테이션만 사용하자.
public class LoginVO implements UserDetails{
	
	private final UserVO userVO;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		for(String role : userVO.getRoleName()) {
			list.add(new SimpleGrantedAuthority(role));
		}
		
		return list;
	}

	@Override
	public String getPassword() {
		return userVO.getPassword();
	}

	@Override
	public String getUsername() {
		return userVO.getFullName();
	}

	@Override
	public boolean isAccountNonExpired() {		// 계정 만료 여부
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {		// 계정 잠금 여부
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {	// 계정 패스워드 만료 여부
		return true;
	}

	@Override
	public boolean isEnabled() {				// 계정 사용여부
		return true;
	}
}
