package com.yedam.app.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardMapper;
	
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	@Override
	public List<BoardVO> getList() {
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO getInfo(BoardVO boardVO) {
		return boardMapper.selectBoard(boardVO);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		int result = boardMapper.insertBoard(boardVO);
		return result == 1 ? boardVO.getBno() : -1;		// 이러한 삼항연산자는 변수에 값 담을때 주로 사용함.
	}
}

/*
[1-7] Service 인터페이스를 상속받는 ServiceImpl을 만들자.
	
	private BoardMapper boardMapper;	
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	위 4줄 코드는 의존성 주입하는 코드이므로, 세트로 반드시 사용하자.
	여기서는 생성자가 하나뿐이므로 @Autowired 어노테이션을 생략해도 상관 없음.
	
	




*/