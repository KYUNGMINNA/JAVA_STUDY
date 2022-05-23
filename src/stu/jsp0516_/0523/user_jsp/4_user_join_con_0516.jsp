<%@page import="kr.co.jsp.user.model.UserVO_8_0516"%>
<%@page import="kr.co.jsp.user.model.UserDAO_10_0516"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    
    	/*
    	사용자가 입력한 id를 먼저 얻어와서 중복 체크 먼저 진행.
    	
    	
    	*/
    	request.setCharacterEncoding("utf-8");
    	
    	String id=request.getParameter("id");
    	
    	UserDAO_10_0516 dao=UserDAO_10_0516.getInstance();
    	
    	if(dao.confiemId(id)){ //아이디가 중복됨!
    %>
    	<!-- <script>
    		alert("아이디가 중복되었습니다");
    		history.back();
    	</script>
	    		 -->
    <%}else { //아이디가 중복되지 않음!
    	
    	//회원 가입 처리가 들어가면 됩니다.
    	//"회원 가입을 환영하빈다" -->user_login.jsp로
    	String pw=request.getParameter("pw");
    	String name=request.getParameter("name");
    	String email=request.getParameter("email");
    	String address=request.getParameter("address");
    	
    	UserVO_8_0516 vo=new UserVO_8_0516(id,pw,name,email,address);
    	
    	dao.insertUser(vo);
    %>
    <script>
    alert("회원가입을 환영합니다!");
    location.href="5_user_login_0516.jsp";
    </script>
    	
    	
    
<%}%>
    
    
    
    
  
    
    