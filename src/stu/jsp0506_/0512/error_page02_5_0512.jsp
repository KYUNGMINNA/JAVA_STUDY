<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- error_page01_4_0512.jsp에서  에러발생하면  해당 페이지로 전달하게 했는데 , 
해당 페이지가 에러 처리할 페이지가 맞음을 작성 ::이래야   'exception 내장 객체' 사용가능
 --%>    
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>
		요청 처리 과정에서 에러가 발생했습니다<br>
		빠른 시간 내에 문제를 해결하겠습니다<br>
		잠시만 기다려 주세요 ㅠㅠ	
	
	</p>
	
	<p>
		에러원인:<%=exception.getMessage() %><br>
		
	</p>

</body>
</html>