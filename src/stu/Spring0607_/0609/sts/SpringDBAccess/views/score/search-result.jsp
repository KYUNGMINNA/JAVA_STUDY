<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>${stu.stuName}학생성적정보 조회</h2>

	<p>
	#국어:${stu.kor}
	#영어:${stu.eng}
	#수학:${stu.math} 
	#총점:${stu.total}
	#평균:${stu.average}</p>

	<a href="<c:url value='/score/search'/>">점수 개별 조회 </a>

	<p>${msg}</p>
</body>
</html>