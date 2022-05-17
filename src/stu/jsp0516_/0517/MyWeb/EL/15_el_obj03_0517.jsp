
<%@page import="kr.co.jsp.user.model.UserVO"%>
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
	UserVO vo=(UserVO)session.getAttribute("member");

%>

	<p>
	# 이름 :<%=vo.getName() %><br>
	#아이디:<%=vo.getId() %><br>
	#이메일:<%=vo.getEmail() %><br>
	# 주소:<%=vo.getAddress() %><br>
	</p>




	<p>						
	<%--.name은  getName에서 get을 제외한 메서드이름이다.:: 객체변수명 지을 때관례대로 작성하면변수명으로 써도 된다 --%>
	# 이름 :${sessionScope.member.name}<br> <%--이게 정석적인것  ::정확한 변수명작성하면 el이 getter를 알아서 불러온다.--%>
	#아이디:${member.id}<br>
	#이메일:${member.email}<br>
	# 주소:${member.address}<br>
	</p>












</body>
</html>