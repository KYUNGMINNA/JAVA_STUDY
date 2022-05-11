<%@page import="user.UserRepository_15_0511"%>
<%@page import="user.User_14_0511"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	
	<%
				request.setCharacterEncoding("utf-8");
				
					
					String id=request.getParameter("account");
					String pw=request.getParameter("password");
					String name=request.getParameter("name");
					String nick=request.getParameter("nkickname");
				
					User_14_0511 user=new User_14_0511(id,pw,name,nick);
					
					//static메서드로 만들어서 객체생성없이 호출 가능 
					UserRepository_15_0511.save(user);

					
					UserRepository_15_0511.showUsers();
					
					response.sendRedirect("register_result_16_0511.jsp");
					
					
			%>