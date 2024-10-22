package com.yedam.app.emp.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {

	private EmpMapper empMapper;
	
	// @Autowired : 생성자가 하나만 사용될 경우 생략 가능. 즉, 생성자가 여러개 사용될 경우는 @Autowired를 반드시 사용해야 함.
	public EmpServiceImpl(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}
	
	@Override
	public List<EmpVO> empList() {
		return empMapper.selectAllList();
	}

	@Override
	public EmpVO empInfo(EmpVO empVO) {
		return empMapper.selectInfo(empVO);
	}

	@Override
	public int empInsert(EmpVO empVO) {
		return empMapper.insertInfo(empVO);
	}

	@Override	// AJAX => JSON
	public Map<String, Object> empUpdate(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = empMapper.updateInfo(empVO.getEmployeeId(), empVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", empVO);
		/*
			{
			"result" : true,
			"target" : {
							employeeId : 100,
							lastName: "King",
							...	
						}
			}
		 */
		
		return map;
	}

	@Override
	public Map<String, Object> empDelete(int empId) {
		Map<String, Object> map = new HashMap<>();
		int result = empMapper.deleteInfo(empId);
		
		if (result == 1) {
			map.put("employeeId", empId);
		}
		// 통신(delete) 실패 시 반환: {}
		// 통신 성공 시 반환 : {"employeeId" : 104}
		
		return map;
	}

}

/*
	[2-10] 2-9에서 만들었던 Service 인터페이스를 사용하여 Service를 만들자



	[2-11] @Autowired를 통해 의존성을 주입하자.
		이 때, 생성자가 단 한개일 경우는 어노테이션을 생략 가능함.
		근데... 저걸 왜 쓰는거지?



	[2-12] Map<String, Object>를 사용하는 이유는 프론트엔드가 데이터를 값을 받는 방식이 JSON 형식이고
		또한 위 empUdate의 `result`처럼 수행결과를 포함하거나,
		empDelete의 통신 실패시 빈 객체를 보내어 수행 결과를 유추할 수 있게 끔 만들 수 있기 때문임.




*/