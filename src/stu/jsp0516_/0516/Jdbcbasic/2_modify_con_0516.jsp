<%@page import="kr.co.jsp.board.model.BoardDAO_6_0513"%>
<%@page import="kr.co.jsp.board.model.BoardVO_4_0513"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    
    /*
		 수정에 필요한 파라미터값을 불러와서 그것을 토대로
	   BoardVO 객체를 생성하세요. (제목, 내용만 수정됩니다.)
	   
	   - BoardDAO의 update()를 이용하여 수정한 객체를 DB에 적용시켜 주시고
	    결과가 성공이라면 해당 글 상세보기 페이지로 이동시켜 주세요.
	    결과가 실패라면 list.jsp로 리다이렉팅 해주세요.
   	*/
   		request.setCharacterEncoding("utf-8");
    
    
    
   		/* int bId=Integer.parseInt(request.getParameter("bId"));
    	String title=request.getParameter("title");
    	String content=request.getParameter("content");
   
     	 BoardVO_4_0513 vo=new BoardVO_4_0513();
     		vo.setBoardId(bId);
    		vo.setTitle(title);
    		vo.setContent(content); 
    		
    		BoardDAO_6_0513 dao=BoardDAO_6_0513.getInstance();
    		boolean flag=dao.update(vo);
    		
    		
    		코드양 줄이기 !
 		*/
 		
        	BoardVO_4_0513 vo=new BoardVO_4_0513();    
     		vo.setBoardId(Integer.parseInt(request.getParameter("bId")));
    		vo.setTitle(request.getParameter("title"));
    		vo.setContent(request.getParameter("content")); 
    
    	 
   		if(BoardDAO_6_0513.getInstance().update(vo)){
   			response.sendRedirect("content_11_0513.jsp?bId="+vo.getBoardId());
   		}else{
   			response.sendRedirect("list_9_0513.jsp");
   		}
    	
 
    
    %>