package kr.co.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO_11_0518;

public class RegistService_2_0519 implements IBoardService_1_0519 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		  String writer=request.getParameter("bWriter"); 
		  String title=request.getParameter("bTitle"); 
		  String content=request.getParameter("bContent");
		  BoardDAO_11_0518.getInstance().regist(writer, title, content);
		 
	}

}
