<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
     	int age=Integer.parseInt(request.getParameter("age"));
    
    
    	if(age >=20){
    		//내장객체 response가 제공하는 sendRedirect()메서드를 통해 
    		//원하는 페이지로 강제 이동할 수 있습니다.
    		//괄호 안에 이동시킬 페이지의 URL주소를 적어 주면 된다.
    		response.sendRedirect("res_basic_ok_12_0510.jsp"); // 절대경로 ,상대경로 둘다 가능하다.
    	}else{
    		response.sendRedirect("res_basic_no_13_0510.jsp"); // 절대경로 ,상대경로 둘다 가능
    	}
    %>