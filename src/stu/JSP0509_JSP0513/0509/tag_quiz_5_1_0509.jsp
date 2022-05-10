<%@page import="java.util.Random"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
     
     
     <%--
      - ArrayList를 생성해서 1 ~ 45범위의 난수 6개를 리스트에 저장하세요.
       중복은 발생하면 안됩니다. 중복 방지 로직을 세워서 리스트에 난수를 삽입한 후
       body태그에 리스트 내부의 값을 출력해 주세요.
       난수 생성은 Random객체든, Math.random()이든 상관 없습니다.
   --%>
<%   
	ArrayList<Integer> array=new ArrayList<>(6);
	Set<Integer> set=new HashSet<Integer>();	
	

	//강사 version
	List<Integer> lotto=new ArrayList<>();
	Random r=new Random();
	while(lotto.size()<6){
		int rn=r.nextInt(45)+1;
		
		if(!lotto.contains(rn)){
			lotto.add(rn);
		}
	}
	Collections.sort(lotto);
%>

<% 

	while(set.size()!=6) {
		set.add((int)(Math.random()*45+1));
	}		
	for(Integer s : set) {array.add(s);}
	Collections.sort(array);
%>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로또 번호 생성 결과 </h1>
이번주 로또 번호는  이 번호다<br>
<% for(int i=0;i<=array.size()-1;i++) {
	out.print(" "+array.get(i) +" ");			 
}%>		

<hr>
<%-- 강사 version --%>
<h1>로또 번호 생성 결과  강사 version</h1>
<p>이번주 로또 번호는  이 번호다<br></p>
<%
		//오토 박싱에 의해  int도 가능 ,물론 Integer도 가능
	for(int i :lotto){        // { % >   < % = i % >    <% } % > 
		out.print(" "+i+" " );
		
	}
%>



</body>
</html>
