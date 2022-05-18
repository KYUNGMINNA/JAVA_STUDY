<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<%-- session.setAttribute("user",vo)    vo클래스의 변수명  id ,name,email,address --%>
	<p>
		#아이디:${sessionScope.user.id}<br>
		#이름 :${user.name}<br>
		#이메일:${user.email}<br>
		#주소:${user.address}




</body>
</html>