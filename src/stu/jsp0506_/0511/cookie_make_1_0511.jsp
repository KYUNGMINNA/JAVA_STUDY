<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		//# 쿠키 생성방법
		//1.쿠키의 객체를 생성 - 생성자의 매개값으로 쿠키의 이름과 저장할 데이터를 입력(이름,데이터 String만 )
		
		String id="abc1234";
	
		//javax.servlet.http에 있는데 ,JSP에서는 따로 import안해줘도 되지만 나중에 클래스에서 쿠키 사용할 때는 직접 import해야 한다.
		//Cookie는 내장 객체 아님 
		Cookie idCoo=new Cookie("id_cookie",id);
		
		Cookie nameCoo=new Cookie("name_cookie","홍길동"); //쿠키는 문자열만  , 문자열 사이 공백도 숫자도 안됨
		
		//2.쿠키 클래스의 setter 메서드로 쿠키의 속성을 설정.
		//쿠키는 수명 지정하지 않으면 동작하지 않음  --setMaxAge(초 단위)  :수명 지나면 자동 소멸
		nameCoo.setMaxAge(60*60); //쿠키의 유효시간 설정(초) : 1시간 ->60*60
		idCoo.setMaxAge(20);
		
		//3.http 응답시 response 객체에 생성된 쿠키를 탑재하여 클라이언트로 전송.
		response.addCookie(nameCoo);
		response.addCookie(idCoo);
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="cookie_check_2_0511.jsp">만든 쿠키 확인하기!</a><br>
	<a href="cookie_check_all_3_0511.jsp">모든 쿠키 확인하기!</a>







</body>
</html>