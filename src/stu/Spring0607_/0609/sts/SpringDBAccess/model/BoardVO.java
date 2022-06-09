package stu.Spring0607_;

public class BoardVO {

	private int boardNo;
	private String writer;
	private String title;
	private String content;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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
	
	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", writer=" + writer + ", title=" + title + ", content=" + content + "]";
	}
	
	public BoardVO() {
	}
	public BoardVO(int boardNo, String writer, String title, String content) {
		super();
		this.boardNo = boardNo;
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
	
}
