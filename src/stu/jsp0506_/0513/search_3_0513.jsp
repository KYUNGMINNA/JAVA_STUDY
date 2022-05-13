<%@page import="kr.co.jsp.score.model.ScoreVO_10_0512"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.jsp.score.model.ScoreDAO_13_0512"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		/*
			SQL문에서 LIKE절을 사용할 때 %를 ?에 직접 붙이면 저상 동작이안됨 ( %?%  안된다)
			?를 채울 때 pstmt객체의 setString()을 이용해 채우게 되는데,
			setString()은 ''를 자동으로 추가해 주기 때문에,
			%가 '' 안으로 들어가지 못하는 상황이 발생( %' '%가 됨)
			SQL에는 ? 만 쓰고 , ? 를 채울 때 검색어에 미리 %를 앞 ,뒤로 연결해서 
			채워주면 된다.
			
			
			(setString()메서드 호출할때 붙여도 된다. )
			eX) pstmt.setString(1,"%"+keyword+"%");
			둘다 가능
			String keyword="%"+request.getParameter("keyword")+"%";
				
		
		*/
		String keyword="%"+request.getParameter("keyword")+"%";
		
		 /*
	       DAO클래스에 search라는 이름의 메서드를 선언해서 검색 결과를 리턴하세요.
	       리턴된 결과를 테이블 형식으로 body 내부에 출력해 주시면 되겠습니다.
	       테이블 형식은 score_list.jsp에 있는 테이블을 참조하세요.
	       
	       검색 결과가 없다면 브라우저 화면에 테이블 대신 '검색 결과가 없습니다.'
	       라고 출력하시고 목록으로 돌아갈 수 있는 링크를 추가하세요.
	      */
	ScoreDAO_13_0512 dao=ScoreDAO_13_0512.getInstance();
	List<ScoreVO_10_0512> scoreList=dao.search(keyword);     
	%>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>검색 결과 </h1>
<%
	// scoreList.isEmpty()와 같다
	if(scoreList.size()==0){%>
		<h2>검색 결과가 없습니다</h2>
			
	<%}else{ %>
		<table border=1>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
				<th>비고</th>
			</tr>
			<% for(ScoreVO_10_0512 vo: scoreList){%>
				<tr>
					<td><%=vo.getId() %></td>
					<td><%=vo.getName() %></td>
					<td><%=vo.getKor() %></td>
					<td><%=vo.getEng() %></td>
					<td><%=vo.getMath() %></td>
					<td><%=vo.getTotal() %></td>
					<td><%=vo.getAverage() %></td>
					<td><a href="delete_2_0513.jsp?id=<%=vo.getId()%>">[삭제]</a></td>
				</tr>			
			<%} %>
		</table>

<%} %>
	<br>
	<a href="score_list_1_0513.jsp">점수 목록 보기</a>	
</body>
</html>