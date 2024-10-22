package com.yedam.app.emp.mapper;
// 		com.yedam.app.**.mapper

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;


public interface EmpMapper {
	// Mapper의 메소드는 SQL문의 실행 형태를 그대로 반영
	// 전체조회
	public List<EmpVO> selectAllList();	
	
	// 단건조회
	public EmpVO selectInfo(EmpVO empVO);	// 기본키만 사용하는 경우(int를 매개변수로)도 있지만
											// 상황에 따라 여러 값을 매개변수로 넘기는 경우도 있음.
	// 등록
	public int insertInfo(EmpVO empVO);
	
	// 수정
	public int updateInfo(@Param("id") int eid, 
						  @Param("emp") EmpVO empVO);
	
	// 삭제
	public int deleteInfo(int employeeId);
}

/*
	[2-3] application.properties에 있는 mybatis.mapper-locations 값에 맞춰
		패키지를 구성해주고 인터페이스를 제작하자.
		CRUD 4개를 구성할거라 생각하지만 보통은 단건조회까지 추가로 5개의 추상메소드를 만듦. 


	[2-7] XML에 넘기는 파라미터가 여러 개 있을 경우, 파라미터에 별칭을 지정할 수 있음.
		org.apache.ibatis.annotations 안에 있는 Param. 즉, @Param 어노테이션을 파라미터 앞에 지정함으로써
		사용 가능함.

*/