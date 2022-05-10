<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
	Date date=new Date(); //현재 날짜 시간정보를 가지고 있는 객체

	SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");// 날짜 형식 지정
	
	String dayInfo=sdf.format(date);  //지정된 날짜 형식으로 현재 날짜 시간정보를 문자열로 리턴

%>
오늘은 <%=dayInfo %> 입니다.





</body>
</html>