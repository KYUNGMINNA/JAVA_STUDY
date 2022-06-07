<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%-- form에 action이  않쓰여있을 때 , 요청으로 들어온 URL로 action이 간다.
		즉, 요청이 들어온 URL으로 다시 action을 보내고 싶을 때 action 생략이 가능하다.
		전송방식인 method 만 달라지기 때문에 , Controller에서 @PostMapping만 작성하면된다.
		
		form 태그의 action을 작성하지 않으면 
		마지막 요청(현재 화면을 보기 위해 요청한 URL 주소)
		url과 동일하게 서버로 요청이 들어갑니다.
		
	 --%>
	<form method="post">
		<p>
			# ID: <input type="text" name="userId" size="10"> <br> #
			비밀번호: <input type="password" name="userPw" size="10"> <br>
			# 비밀번호 확인: <input type="password" name="userPwChk" size="10">
			<br> <input type="submit" value="로그인">
		</p>
	</form>
	
	<p style="color :red; ">
		${msg}
	</p>










</body>
</html>















