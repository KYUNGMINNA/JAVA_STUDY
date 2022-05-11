<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
     	//클라이언트 쪽에서 전송된 쿠키를 가져오는 방법.(왜냐면 쿠키는 요청에 포함되어 가기 때문)
     	Cookie[] cookies=request.getCookies();//모든 쿠키가 와서 배열로 받음
     	boolean flag=false; //쿠키의 존재 유무를 파악할 변수를 임의로 제작
     	
     	//쿠키 찾을때는 null체크 먼저 해주는것이 좋다.
     	if(cookies !=null){
     		for(Cookie c:cookies){
     			//쿠키의 이름을 얻어오는 메서드 getName()
     			if(c.getName().equals("id_cookie")){
     				out.print("<h3>아이디 쿠키가 존재합니다</h3>");
     				String value=c.getValue(); //쿠키 내부의 값을 얻어오는 메서드 getValue()
     				out.print("쿠키의 값:"+value);
     				flag=true;
     				break;
     			}
     		}
     		//flag가  false인가?
     		if(!flag){
     			out.print("<h3>아이디 쿠키가 사라졌거나 존재하지않습니다.</h3>");
     		}
     	}
     	
     	
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>