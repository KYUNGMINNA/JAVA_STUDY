<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--class로 직접 요청은 불가능 하다   -- 가상의 URL을 설정하여 보내야 한다 (web.xml에 ㅅ ㅓ블릿을 등록해ㅑㅇ한다) --%>
	<form action="/MyWeb/basic" method="post">  <%-- /MyWeb 은 context_root 이기 때문에 무조건 들어가야됨 --%>
		#아이디:<input type="text" name="account"><br>
		<input type="submit" value="서블릿 페이지 열어보기">
	</form>


</body>
</html>
