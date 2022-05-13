package kr.co.jsp.board.model;

import java.util.List;

//인터페이스이름  앞에 대문자 I를 붙여주는것이 관례이다.
public interface IBoardDAO_5_0513 {
	
	/*
	 인터페이스 : 클래스를 만들기 위한 틀 역할을 한다.
	 클래스와는 다르게 혼자서는 무엇인가를 할 수 가 없다(일반 멤버변수(변수와,메서드)선언 불가능)
	 추상메서드만 만 선언가능 
	 
	 
	 
	*/
	
	
	//추상메서드 작성할때 어떤 SQL사용할지 정하면 된다 // 
	
	//게시글 등록
	boolean insert(BoardVO_4_0513 vo);
	
	//게시글 전체 조회
	List<BoardVO_4_0513> selectAll();
	
	//게시글 상세 조회
	BoardVO_4_0513 selectOne(int bId);
	
	//게시글 수정
	boolean update(BoardVO_4_0513 vo);
	
	//게시글 삭제
	boolean delete(String bId);
}
