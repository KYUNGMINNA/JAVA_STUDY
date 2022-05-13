<%@page import="java.sql.Timestamp"%>
<%@page import="kr.co.jsp.board.model.BoardDAO_6_0513"%>
<%@page import="kr.co.jsp.board.model.IBoardDAO_5_0513"%>
<%@page import="kr.co.jsp.board.model.BoardVO_4_0513"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    
    /*
    1. 사용자의 입력값을 가져오세요. 그리고 객체로 포장하세요.
    2. DAO클래스의 주소값을 받아 DB에 내용을 삽입하는 메서드를 호출하세요.
    (board_id -> 시퀀스 객체로 삽입, 날짜는 넣어줄 필요가 없다.)
    3. 글 등록 성공 시 list.jsp로 리다이렉팅,
    4. 글 등록 실패 시 write.jsp로 리다이렉팅 해 주세요.
    */
    
    	request.setCharacterEncoding("utf-8");
		
    	String writer=request.getParameter("writer");
    	String title=request.getParameter("title");
    	String content=request.getParameter("content");
    	
    	// 이렇게 작성해도 되지만 ,굳이 그럴필요는 없다.
    	//Timestamp timestamp=null;
    	// BoardVO_4_0513 vo=new BoardVO_4_0513(0,writer,title,content,timestamp);
    	  
    	//강사 version
    	BoardVO_4_0513 vo=new BoardVO_4_0513();
    	vo.setWriter(writer);
    	vo.setTitle(title);
    	vo.setContent(content);
    	
    	IBoardDAO_5_0513 dao=BoardDAO_6_0513.getInstance();
    	boolean flag=dao.insert(vo);
    	
    	// if(BoardDAO_6_0513.getInstance().insert(vo))
    		
    		if(flag){
    			response.sendRedirect("list_9_0513.jsp");
    		}else{
    			response.sendRedirect("write_7_0513.jsp");
    		}
    
    %>
