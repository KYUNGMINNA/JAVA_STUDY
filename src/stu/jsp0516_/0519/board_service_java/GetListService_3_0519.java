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
		request.setAttribute("bList", boardList);
	}

}
