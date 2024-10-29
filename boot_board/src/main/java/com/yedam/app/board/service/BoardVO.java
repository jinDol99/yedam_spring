package com.yedam.app.board.service;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Integer bno;			// 게시글 번호, PK
	private String 	title;			// 게시글 제목, NOT NULL
	private String	content;		// 게시글 내용
	private String	writer;			// 게시글 작성자, NOT NULL
	private Date	regdate;		// 게시글 작성일자, NOT NULL
	private Date	updatedate;		// 게시글 수정일자
	private String	image;			// 첨부 이미지 파일
}

/*
[1-1] board.service 패키지 아래에 VO 만들기
	Date Import 할때는 java.util.Date 를 선택하자!
	그리고 웬만하면 주석을 잘 달아주자.




*/