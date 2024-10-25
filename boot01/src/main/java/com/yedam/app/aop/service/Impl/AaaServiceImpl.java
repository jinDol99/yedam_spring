package com.yedam.app.aop.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;
import com.yedam.app.aop.service.AaaService;

import lombok.RequiredArgsConstructor;

@Service	// AOP가 적용될 대상
@RequiredArgsConstructor
public class AaaServiceImpl implements AaaService {
	private final AaaMapper aaaMapper;
	
	@Transactional
	@Override
	public void insert() {
		aaaMapper.aaaInsert("101");
		aaaMapper.aaaInsert("a101");
	}
}

/*
	[6-2] @Transactional 어노테이션 없이 여러 INSERT를 수행한다고 가정하자.
		위 예시 코드처럼 숫자를 NUMBER 전용 테이블에 삽입하는 동작 2개를 하는데
		보다시피 첫 번째 Insert는 정상적인 숫자지만, 두 번째 Insert는 문자가 끼여있는 비정상적인 숫자임.
		
		이 과정에서 JUnit 등으로 DB 테스트를 한다면 Invalid Number 오류가 당연히 뜰 것임.
		오류가 뜬 이후 DB의 aaa 테이블을 확인해볼 경우, a101은 INSERT가 안되었지만 101은 INSERT가 되어졌음.
		
		의도한 것이면 상관없지만, 2개 이상의 통신(트랜젝션) 중 1개라도 오류가 발생했다면 바로 통신을 끊지만
		이미 진행된 트랜젝션 건(여기서는 ` aaaInert("101") `)은 
		
	 	
	 	
	 	이 때 
		
		모든 통신을 롤백하는 경향이 있음. (예약, 결제, 포인트 INSERT 중 하나라도 안되면 모두 취소하는 것 처럼)


*/