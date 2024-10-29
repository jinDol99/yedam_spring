package com.yedam.app.board.mapper;

import java.util.List;
import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	// 전체조회
	public List<BoardVO> selectBoardList();
	
	// 단건조회: 조건 - bno
	public BoardVO selectBoard(BoardVO boardVO);
	
	// 등록: 대상 - bno(selectKey), title, content, writer, regdate, image
	public int insertBoard(BoardVO boardVO);
	
}
/*
[1-2] board.mapper 패키지 아래에 mapper 인터페이스 만들기
	SQL을 통해 어떤 것을 조회, 수정, 삭제할 것인지 미리 생각해두고 인터페이스를 만들자.
	위 예시에서는 "전체조회", "단건조회", "등록" 3개를 만들었음.
	만들 때 파라미터와 리턴타입을 잘 생각하고 확인하자.


*/