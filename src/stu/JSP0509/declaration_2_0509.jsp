<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--declaration_2_0509.jsp로 요청이 오면   WAS는  ,JSP파일을 클래스 파일로 만든다.(클래스 파일로만들어져 객체가 생성이된다.
객체는 싱글톤임  -->
<%!   // 클래스 블록  ::전역 변수 =멤버 변수   ||메서드 선언 ,값 누적 시 사용 
	
	/*
	Declaration(선언자) < %!% >은 jsp 파일 내부에서 사용할 멤버변수나 메서드 등을 선언할 때 사용하는 태그
	선언자에 작성한 코드는 jsp파일이 클래스로 변환될 때 실제 클래스 블록에 선언된다.
	해당 클래스로 객체가 생성될 때 , 멤버변수(속성),메서드(기능)로 동작하기 때문에 
	객체가 소멸하지 않는 이상 요청이 들어온다면 값을 계속해서 누적(유지)할 수 있고
	메서드의 호출 또한 가능합니다.
	
	*/

	public int i;

	public int add(int n1,int n2){
		return n1+n2;
	}
%>

<%   // 요청이 들어올 때마다 초기화 된다.  
	// 메서드 블록 :지역변수 (지역변수는 사용하려면 초기화 해야함) ::메서드 내부로 들어감(당연히 메서드 선언불가)
	//메서드의 호출은 메서드 내부 , 생성자에서만 사용     || 지역변수(메서드 호출시 생성,종료시 사라짐)
	
	
	/*  < %  % > 
	Scriptlet(스크립틀릿)은 지역변수 및 메서드 내부의 코드를 작성하는 태그
	스크립틀릿에 작성한 내용은 jsp파일이 클래스로 변환될 때 jsp_service()라는 메서드 내부에 작성됩니다.
	페이저 요청이 발생할 때 마다 실행할 로직을 작성할 수 있다.
	
	*/
	
	
	
	//메서드 호출할 때마다 생성되고 , 메서드 호출 종료시 사라짐(초기화)
	 int j=3;  // 접근제어 public 사용하면안됨
	
	 /* void hello(){
		out.print("안녕~");
	} */
	 
	i++;
	j++;
	
	int result=add(7,8);
	double rn=Math.random();
%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	i의 값:<%=i %><br>
	j의 값:<%=j %><br>
	result의 값:<%=result %><br>
	난수의 값:<%=rn %>




</body>
</html>
