<%@page import="kr.co.jsp.board.model.BoardDAO_6_0513"%>
<%@page import="kr.co.jsp.board.model.BoardVO_4_0513"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    //요청과 함께 넘어오는 파라미터 값(글 번호)을 얻어와서 
    //DAO의 selectOne() 호출하여 객체를 받아오세요
    
    String bId=request.getParameter("bId");
    
    
    BoardVO_4_0513 vo=BoardDAO_6_0513.getInstance().selectOne(bId);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>???번 게시물 내용</h1>
	
	<p>
		#작성자:??<br>
		#제목:??<br>
		#내용:??<br>
		<textarea rows="5" readonly>???</textarea><br>
		#작성일 :???
	</p>
	
	<a href="list_9_0513.jsp">글 목록보기</a>
</body>
</html>