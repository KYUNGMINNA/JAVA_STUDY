<%@page import="user.User_14_0511"%>
<%@page import="user.UserRepository_15_0511"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
   		User_14_0511 user=(User_14_0511)session.getAttribute("login");
    
    	
     	UserRepository_15_0511.deleteUser(user.getAccount());
    	session.invalidate();

    %>
	<script>
	alert("회원탈퇴처리되었습니다.");
	location.href="login_form_17_0511.jsp";
	</script>
