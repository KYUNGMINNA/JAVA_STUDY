<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    
 <%
 	String name="홍길동";
 	String address="서울특별시";
 %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
		out.print("이름 :"+name+"<br>");
		out.print("주소 :"+address+"<br>");
	%>
	<hr>
	이름:<%=name%><br> <!--  out.print(name)으로 자동 변환이 됨 -->
	주소:<%=address%><br>
	난수값:<%=Math.random() %><br>
	
	<hr>
	
	<h2>구구단 7단</h2>
	<% for(int hang=1;hang<=9;hang++){%>
		7x <%=hang %>=<%=7*hang %><br>
	<%} %>
	
</body>
</html>
