<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	UserVO vo=(UserVO)session.getAttribute("user");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 성공</h1>
<%=vo.getId()%><br>
<%=vo.getPw()%><br>
<%=vo.getName()%><br>
<%=vo.getEmail()%><br>
<%=vo.getAddress()%><br>
</body>
</html>