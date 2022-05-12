<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>


<%--에러 발생하면 전달할 페이지 작성 --%>    
<%@ page errorPage="error_page02_5_0512.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<%--id 값 안주면 ,NullPointerException발생 
		 --%>
	<%= request.getParameter("id").toLowerCase()%>
	
	
	
	
</body>
</html>