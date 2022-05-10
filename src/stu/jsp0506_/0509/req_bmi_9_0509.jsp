<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
       bmi지수 계산 공식: 체중(kg) / 신장(m) * 신장(m)
       - bmi지수가 25를 초과한다면 "당신은 과체중입니다." 를 출력
       - 18.5미만이라면 "당신은 저체중입니다." 를 출력
       - 나머지는 "당신은 정상체중입니다." 를 출력하세요.
       
       주의!) 
       request.getParameter()의 리턴 타입은 String입니다.
       숫자가 전달되어도 타입이 문자열입니다.
       그렇기 때문에 bmi 지수를 계산하려면 실수나 정수로 변환 후 계산해야 합니다.
       Integer.parseInt(문자열), Double.parseDouble(문자열)
       신장 -> cm, 체중 -> kg 두 값 모두 소수점 포함 값으로 받도록 하겠습니다.
     --%>
     
     <%
     	//넘어오는 파라미터값 받고 실수로 변환
     	String str_cm=request.getParameter("cm");
     	String str_kg=request.getParameter("kg");
    	
  		
		double bmi=Double.parseDouble(str_kg)/((Double.parseDouble(str_cm)/100)*(Double.parseDouble(str_cm)/100));

		//강사 version
		double cm=Double.parseDouble(str_cm);
		double kg=Double.parseDouble(str_kg);
		double re_bmi=kg/((cm/100)*(cm/100));
		
			//Math.round()의 결과는 정수(소수점1의자리에서 반올림하기때문)
			//소수점 둘재짜리 까지 구함
		re_bmi=Math.round(re_bmi*100)/100.0;
     %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>체질량 지수(BMI)계산</h1>
<hr>
-신장:<%=cm%>cm<br>
-체중:<%=kg%>kg<br>
BMI 지수:<strong><%=re_bmi%></strong><br>
<% if (bmi>25) { %>
당신은 과체중입니다.
<%} else if(bmi<18.5){ %>
당신은 저체중입니다.
<%} else{ %>
당신은 정상체중입니다.
<%} %>	



</body>
</html>