package kr.co.jsp.board.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO_11_0518;
import kr.co.jsp.board.model.BoardVO_9_0518;

public class SearchService_9_0519 implements IBoardService_1_0519 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String keyword=request.getParameter("search");
		String category=request.getParameter("category");
		
		List<BoardVO_9_0518> searchList =BoardDAO_11_0518.getInstance().searchBoard(keyword, category);
		
		
		
		
			//searchList.size()==0
		  /*if(searchList.isEmpty()) { request.setAttribute("searchFail", true); }else {
		  request.setAttribute("bList", searchList); }
		  
		  //board_list 에 조건문 추가해야됨 
		  	<c:if test="${searchFail }">
			<script>
			alert("조회 결과가 없습니다.");
			location.href="/MyWeb/list.board";
			</script>	
			</c:if> 
			
			
		  //JSP에 오류 발생 가능 성 있어서, 밑에 방법을 사용한다
		 */
		
		
		
		
		
		  if(searchList.size()==0) { //자바 클래스에서 HTML이나 JS 문법을 사용하는 방법 : PrintWriter 객체를사용
			  response.setContentType("text/html; charset=UTF-8");
			  try { PrintWriter
		  out=response.getWriter();
		  
		  //원하는 html /js 코드를 문자열 형태로 작성합니다.
			  String htmlCode = "<script> \r\n" +
		  "alert('검색 결과에 따른 게시물이 없습니다.'); \r\n" +
		  "location.href='/MyWeb/list.board'; \r\n" + "</script>";
		  
		  out.print(htmlCode);//버퍼에 작성한 문자열을 저장합니다.
		  
		  out.flush();//버퍼에 저장되어 있는 내용을 클라이언트로 전송을하고 버퍼를 비웁니다.
		  
		  return; 
		  } catch (IOException e) {
			  e.printStackTrace();
			  }
		  
		  
		  }
		  request.setAttribute("bList", searchList);
		  
		 
		
		
		
		
		
		
		
		
		
		
	}

}
