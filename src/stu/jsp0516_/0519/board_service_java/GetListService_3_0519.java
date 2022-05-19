package kr.co.jsp.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO_11_0518;
import kr.co.jsp.board.model.BoardVO_9_0518;

public class GetListService_3_0519 implements IBoardService_1_0519 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		List<BoardVO_9_0518> boardList=BoardDAO_11_0518.getInstance().listBoard();
		
		//1일 이내 신규게시글 new 마크  처리 로직
		for(BoardVO_9_0518 vo:boardList) {
			//운영체제의 현재 시간을 읽어서 밀리초로 리턴하는 메서드
			//1970년 1월1일 자정을기준으로 현재까지 흐른 시간을
			//밀리초로 리턴합니다.
			long now=System.currentTimeMillis();
		
			//게시물의 작성 시간을 밀리초로 읽어오기
			long regTime=vo.getRegDate().getTime();
			
			if(now-regTime <60*60*24*1000) {
				vo.setNewMark(true);  //boolean은 default가 false 라서 else 굳이 사용안해도됨
			}
		}
		
		
		request.setAttribute("bList", boardList);
	}

}
