package com.yedam.app.board.service;

import java.util.List;

public interface BoardService {
	// 전체조회
	public List<BoardVO> getList();
	
	// 단건조회
	public BoardVO getInfo(BoardVO boardVO);
	
	// 등록
	public int insertBoard(BoardVO boardVO);
	
}
/*
[1-6] board.service 패키지 아래에 서비스 인터페이스를 만들자.

*/