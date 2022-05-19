package kr.co.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO_11_0518;

public class UpdateService_7_0519 implements IBoardService_1_0519 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		  int bId=Integer.parseInt(request.getParameter("bId")); 
		  String title=request.getParameter("bTitle"); 
		  String content=request.getParameter("bContent");
		  BoardDAO_11_0518.getInstance().updateBoard(title, content, bId);
	}

}
