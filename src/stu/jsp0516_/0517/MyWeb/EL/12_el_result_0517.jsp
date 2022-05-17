<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>
		#data1:<%=session.getAttribute("data1") %><br>
		#data2:<%=application.getAttribute("data2") %>
	
	</p>
	
	<hr>
	  <%-- 값을 셋팅하는것은 어쩔 수 없이 자바 코드로 작성해야 하고 -- 즉 session.setAttribute 이런것
	  
	  	값을 가져오는것은 El문법이 훨씬 쉽고 편하다.
	   --%>
	
	
	
	<%-- 
		*EL에서 데이터를 참조할 때 영역을 명시하지 않는다면,
		page -> request -> session ->application 순서대로 검색하여 찾아내 표현합니다.
		 --session과 application에 중복된 이름의 데이터가 있으면 우선순위가 높은 session의 데이터 나옴.
		 request도 set,getAttribute도 있다 응답나가면 사라짐.
		 
		중복이 됬다 가정하였을 때 ,
		 특정 영역을 지정하려면  requesetScope   , sessionScopre, applicationScope 사용
		
		
		주로 select 돌려서 결과를 화면에 뿌릴 때 el을 사용 
	 --%>
	
	
	<p><%--이름만 써도 알아서 내장객체를 돌면서 값을  가져옴::--%>
		#data1:${data1}<br>
		#data2:${applicationScope.data2}<br>  <%-- 범위를 지정하여 데이터를 조회  --%>
	</p>


</body>
</html>