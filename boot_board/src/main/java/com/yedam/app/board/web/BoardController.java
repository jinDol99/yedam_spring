package com.yedam.app.board.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller		// Endpoint (URI + METHOD) + Service + View
public class BoardController {
	// 의존성 주입
	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// 전체 조회: URI - boardList	/	RETURN - board/boardList
	@GetMapping("boardList")
	public String boardList(Model model ) {
		List<BoardVO> list = boardService.getList();
		model.addAttribute("boards", list);
		return "board/boardList";
	}
	
	
	// 단건 조회: URI - boardInfo	/	PARAMETER - BoardVO		/	RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getInfo(boardVO);
		model.addAttribute("board", findVO);
		return "board/boardInfo";
	}
	
	
	// 등록 - 페이지: URI - boardInsert		/ 	RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsert() {
		return "board/boardInsert";
	}
	
	
	// 등록 - 처리: URI - boardInsert		/ 	PARAMETER - BoardVO		/ 	RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsert(BoardVO boardVO, Model model) {
		int result = boardService.insertBoard(boardVO);
		String url = "board/boardList";
		return url;
	}
	
}

/*
[1-8] 






*/