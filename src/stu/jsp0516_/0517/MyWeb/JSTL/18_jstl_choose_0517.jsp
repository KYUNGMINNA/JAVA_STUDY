<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

						<%-- EL은 값의 타입을 보고 알아서 변환하여 저장 --%>
	<c:set var="age" value="${param.age}"/>
	#이름 : ${param.name }<br>
	#나이 :${age}<br> <%-- age라는 변수명으로 담았기 때문 --%>
	
	
	<%--다중 분기 조건문 ==else  if --%>
	<c:choose>
	
	<%--when의 개수가 무제한  --%>
	<c:when test="${age>=20}">
		<c:choose>   <%-- 이중 중첩은  c:when -> c:choose -> c:when 으로 써야 함!!!! --%>
			<c:when test="${age>=40 }">
				<h3>장년층 입니다.</h3>
			</c:when>
			
			<c:otherwise>
				<h3>청년층 입니다.</h3>
			</c:otherwise>
		</c:choose>
	</c:when>
	
	<c:when test="${age>17= }">
		<h3>당신은 고등학생 입니다.</h3>
	</c:when>
	
	<c:when test="${age>=14 }">
	<h3>당신은 중학생입니다.</h3>
	</c:when>
	
	<c:when test="${age>=8 }">
	<h3>당신은 초등학생입니다.</h3>
	</c:when>
	 
	 <%--ohterwies == else  --%>
	<c:otherwise>
		<h3>당신은 미취학 아동입니다.</h3>
	</c:otherwise>
	
	
	</c:choose>
	








</body>
</html>