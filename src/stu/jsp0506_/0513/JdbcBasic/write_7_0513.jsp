<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h2>게시물 등록</h2>

	<form action="write_con_8_0513.jsp" method="post">
	
		<p>
			#작성자: <input type="text" name="writer" ><br>
			#제목 : <input type="text" name="title"><br>
			#글 내용:<br>
			<textarea rows="3" name="content"></textarea><br>
			<input type="submit" value="등록">
		</p>
	</form>
	

</body>
</html>