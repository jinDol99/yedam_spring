package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
	// 전체조회
	public List<EmpVO> empList();
	
	// 단건조회
	public EmpVO empInfo(EmpVO empVO);
	
	// 등록
	public int empInsert(EmpVO empVO);
	
	// 수정
	public Map<String, Object> empUpdate(EmpVO empVO);
	
	// 삭제
	public Map<String, Object> empDelete(int empId);
	
}

/*
	[2-9] Service 인터페이스를 만들어서 Mapper와 Controller? 단을 연결하자.
		여기서는 크게 만들건 없고 5개의 CRUD만 잘 만들자.
		수정과 삭제가 Map을 사용하는 이유는 후술.

*/