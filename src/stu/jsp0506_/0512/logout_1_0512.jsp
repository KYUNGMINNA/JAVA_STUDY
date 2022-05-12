<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//특정 세션만 종료 할 때 
    	//session.removeAttribute("login");
    	
    
	    //모든 세션 삭제
	    session.invalidate();
	    
	    
    %>
	<script>
	alert("로그아웃 처리되었스니다.");
	location.href="login_form_17_0511.jsp";
	
	</script>
