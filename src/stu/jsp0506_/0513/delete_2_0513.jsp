<%@page import="kr.co.jsp.score.model.ScoreVO_10_0512"%>
<%@page import="kr.co.jsp.score.model.ScoreDAO_13_0512"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	/*
	파라미터 데이터(int)를 얻어오신 후 DAO에게 삭제 요청 해 주시면 됩니다.
	(DAO의 주소값 받아와서 메서드 호출)
	public boolean delete(???) <- DAO 클래스에 선언하세요.
	
	삭제가 완료되면 score_list.jsp로 이동.
	삭제가 실패해도 score_list.jsp로 이동.
	삭제가 성공했는지, 실패했는지의 여부를 script 태그를 이용하여
	경고창으로 알려 주세요.
	location.href="URL" -> 이걸로 이동시키기.
	*/

	int id=Integer.parseInt(request.getParameter("id"));
	
	ScoreDAO_13_0512 dao=ScoreDAO_13_0512.getInstance();
	
	boolean flag=dao.delete(id);
	
	// if(ScoreDAO_13_0512.getInstance().delete(id)) 로도 쓸 수 있다.
	
	if(flag){
%>
		<script>
		alert("삭제 성공");
		location.href="score_list_1_0513.jsp";
		</script>
<%}else{ %>
	<script>
		alert("삭제 실패");
		location.href="score_list_1_0513.jsp";	
	</script>
<%} %>
	

