<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%-- <%
		String name=request.getParameter("name");
		String nick=request.getParameter("nick");
	
	
	%>
 --%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <p>
		#이름 :<%=name %><br>
		#별명 :<%=nick %><br>
	</p>
	 --%>
	 
	 <p> <%--값을 바로 사용하기 위해 주로 사용함 EL :: 파라미터값을 바로 참조할수 있는 내장객체 param   
	 	 request.getParamert() 는 값 안오면 null 오지만 , EL은 공백으로 온다 !!!!
	 	--%>
	 	#이름:${param.name}<br>
	 	#별명:${param.nick}
	 </p>
	 
	 <%
	 	session.setAttribute("data1", "hello~!");
	 	application.setAttribute("data2", "byte~");
	 	session.setAttribute("data2","이름은 같지만 다른 데이터");
	 
	 
	 %>
	 	<a href="12_el_result_0517.jsp">세션,어플리케이션 데이터를 화면에 출력하기</a>
	 
</body>
</html>