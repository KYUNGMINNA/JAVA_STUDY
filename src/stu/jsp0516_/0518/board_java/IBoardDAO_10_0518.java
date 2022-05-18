package kr.co.jsp.board.model;

import java.util.List;

public interface IBoardDAO_10_0518 {
	
	//글 등록 메서드 
//	void regist(BoardVO_9_0518 vo); -- 파라미터 객체로 작성해도 됨 
	void regist(String writer,String title,String content);
	
	//글 전체 목록 가지고 오는 메서드
	List<BoardVO_9_0518> listBoard();
	
	//글 상세보기 요청을 처리할 메서드
	BoardVO_9_0518 contentBoard(int bId);
	
	
	//글 수정 요청을 처리할 메서드(제목,내용)  
//	void updateBoard(BoardVO_9_0518 vo); --객체도 가능 
	void updateBoard(String title,String content,int bId);
	
	
	//글 삭제 요청을 처리할 메서드
	void deleteBoard(int bId);
}
