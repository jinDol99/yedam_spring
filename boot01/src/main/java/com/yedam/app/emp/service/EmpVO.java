package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpVO {
	private Integer	employeeId;			// JS에서 넘어올때 공백이 붙는 등 잘못된 값이 넘어오는 상황을 방지하기 위해
										// int가 아닌 Integer 타입 사용
	private String	firstName;
	private String	lastName;
	private String	email;
	private String	phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	hireDate;
	private String	jobId;
	private Double	salary;				// 기본적으로 체크 제약조건은 0보다 커야하기 때문에 double이 아닌 Double 타입 사용
	private double	commissionPct;
	private Integer	managerId;			// 포린키 제약조건으로 인해 int가 아닌 Integer 타입 사용
	private Integer	departmentId;		// managerId와 동일한 이유
}

/*
	//============================================================
	//== 웹 만들기 ================================================
	
	[2-1] 우선 VO를 만들자. 늘 만든것 처럼 새로운 패키지(service)와 VO 클래스를 만들고
		@Data 어노테이션(게터와 세터 그리고 toString() 오버라이딩 해줌)을 지정하자.
	
	[참고] @Data 어노테이션만 쓰면 뭐가 뭔지 모르는 경우도 있기 때문에 위처럼
		Getter, ToString 등을 하나하나 쓰는 경우도 있긴 있음.
		
	
	[2-2] VO를 만들때 기본타입이냐 참조타입이냐를 결정할때는 DB의 제약조건을 잘 파악하고 넣어야 함
 */
