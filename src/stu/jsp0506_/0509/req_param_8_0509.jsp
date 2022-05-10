<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%--
    	#요청 파라미터(request parameter)
    	
    	-클라이언트 측에서 서버로 데이터를 요청할 때 함께 전달되는 값들을 
    	담은 변수를 요청 파라미터라고 한다.
    	
    	-요청 파라미터는 URL주소 뒤에 ?를 붙인 후에 [파라미터변수명=값] 의 
    	형식을 통해서 서버로 데이터를 전송합니다.
    	
    	- 요청 파라미터를 여러개 전달할 때는 & 기호를 사용하여 나열해서 전달한다.
    	
    
     --%>
    <%  
//http://localhost:8181/JspBasic/JspObjRequest_7_0509/req_param_8_0509.jsp?name=홍길동&age=30&address=서울특별시
    	//클라이언트 쪽에서 전송된 요청 파라미터값을 읽는 방법.
    	String name=request.getParameter("name"); // "변수명"  
    									//숫자가 와도 문자로 리턴함 
    	String age=request.getParameter("age");
    	String addr=request.getParameter("address");
    	//reqeust는 getParameter값 없으면 null 
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p> 
이름 : <%=name %><br>
나이: <%=age%>세<br>
주소 : <%=addr %><br>

</p>
</body>
</html>