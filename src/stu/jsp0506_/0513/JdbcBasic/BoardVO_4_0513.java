package kr.co.jsp.board.model;

import java.sql.Timestamp;

public class BoardVO_4_0513 {
	
	
	//자바는  언더바 상수에만 붙임  ,자바는 변수이름이나 메서드에 언더바 사용 잘 안함 || 자바는 카멜케이스
	private int boardId;
	private	String writer;
	private	String title;
	private	String content;
	private	Timestamp regDate;
	
	public BoardVO_4_0513() {
	// TODO Auto-generated constructor stub
	}

	public BoardVO_4_0513(int boardId, String writer, String title, String content, Timestamp regDate) {
		super();
		this.boardId = boardId;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	


	
}
