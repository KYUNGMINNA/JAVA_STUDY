package kr.co.jsp.board.model;

import java.sql.Timestamp;

/*CREATE TABLE my_board(
	    board_id NUMBER PRIMARY KEY,
	    writer VARCHAR2(30) NOT NULL,
	    title VARCHAR2(100) NOT NULL,
	    content VARCHAR2(2000),
	    reg_date DATE DEFAULT sysdate,
	    hit NUMBER DEFAULT 0
	);
	CREATE SEQUENCE board_seq 
	    START WITH 1
	    INCREMENT BY 1
	    MAXVALUE 1000
	    NOCACHE
	    NOCYCLE;*/
public class BoardVO_9_0518 {
	private int boardId;
	private String writer;
	private String title;
	private String content;
	private Timestamp regDate;
	private int hit;
	
	public BoardVO_9_0518() {
	}

	public BoardVO_9_0518(int boardId, String writer, String title, String content, Timestamp regDate, int hit) {
		super();
		this.boardId = boardId;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	

	

}
