<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	//post방식일 때는 인코딩 방식을 변경하는것이 좋다.
    	request.setCharacterEncoding("utf-8");
    
    	String id=request.getParameter("id");
    	String pw=request.getParameter("pw");
    
    	if(id.equals("abc1234") && pw.equals("aaa1111")){
    		Cookie loginCoo=new Cookie("login_cookie",id);
    		loginCoo.setMaxAge(5);
    		response.addCookie(loginCoo);
    		
    		//사용자가 아이디 기어하기 체크박스를  체크한 경우.
    		if(request.getParameter("id_remember") !=null){
    			Cookie idMemo=new Cookie("remember_id",id);
    			idMemo.setMaxAge(30);
    			response.addCookie(idMemo);
    			
    		}
    		
    		
    		
    		response.sendRedirect("cookie_welcome_6_0511.jsp");
    	}else{
    		response.sendRedirect("cookie_login_4_0511.jsp");
    	}
    %>