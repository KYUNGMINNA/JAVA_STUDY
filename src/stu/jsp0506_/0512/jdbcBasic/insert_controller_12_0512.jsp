<%@page import="kr.co.jsp.score.model.ScoreDAO_13_0512"%>
<%@page import="kr.co.jsp.score.model.ScoreVO_10_0512"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		int kor=Integer.parseInt(request.getParameter("kor"));
		int eng=Integer.parseInt(request.getParameter("eng"));
		int math=Integer.parseInt(request.getParameter("math"));
		
		int total=kor+eng+math;
		double avg=total/3.0;// 정수/정수는 정수라서 double로 나눠야 함
		
		ScoreVO_10_0512 vo=new ScoreVO_10_0512(0,name,kor,eng,math,total,avg);

		ScoreDAO_13_0512 dao=ScoreDAO_13_0512.getInstance();
		boolean flag=dao.insert(vo); //빠르게 이동 insert커서 F3 
		
		if(flag) {
			response.sendRedirect("insert_success_14_0512.jsp");
		}else{
			response.sendRedirect("insert_form_11_0512.jsp");
		}
		
	%>