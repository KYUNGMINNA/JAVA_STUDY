<%@page import="kr.co.jsp.user.model.UserDAO"%>
<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    	request.setCharacterEncoding("utf-8");
    	String checkpw=request.getParameter("check_pw");
    	
    	UserDAO dao=UserDAO.getInstance();
    	UserVO vo=(UserVO)session.getAttribute("user");
		String id=vo.getId();
    	
    	if(dao.userCheck(id, checkpw)==1){
    		dao.deleteUser(id);
    		session.invalidate();
    %>
    		<script>
    		alert("삭제되었습니다.");
    		//location.href="user_login.jsp";
    		ㅣocation.href="/MyWeb";
    		//location.href="/MyWeb"; -- 강사 버전 :: context루트(프로젝트 자체)를 지정하였음 -- 자동으로 index.jsp로 감 
    		</script>
<%}else{%>
		<script>
		alert("비밀번호가 일치하지 않습니다. ");
		//location.href="user_mypage.jsp"; -- 강사 버전
		history.back();
		</script>    	
<%} %>
    
