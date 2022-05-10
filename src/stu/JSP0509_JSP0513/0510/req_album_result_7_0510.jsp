<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    
    	 String s=request.getParameter("title");
    
    
    	String title = request.getParameter("title");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">선택하신 앨범 정보 </h1>
<hr>
<p align="center">당신이 선택하신 앨범은  <strong><%=s.equals("sel1")? '가' :'나' %></strong>의 
  <strong><%=s.equals("sel1")? 10:20%></strong>입니다.</p>
<hr>
<h2 align="center"> 동영상</h2>
<div align="center">
<iframe  width="545" height="307" src=<%=s.equals("sel1")?"https://www.youtube.com/embed/on09zv-ujyc?autoplay=1":"https://www.youtube.com/embed/3_m3NBvDye4"%> title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>

</iframe>  
</div>

  
  
  
   <% if(title.equals("sel1")) { %>
      <div align="center">
         <h2>선택하신 앨범 정보</h2>
         <hr>
         <p>
            당신이 선택하신 앨범은 싸이 (PSY)의 <strong>That That (prod. & feat. SUGA of BTS)</strong> 입니다.
         </p>
         <hr>
         <h3>타이틀 곡 뮤직 비디오</h3>
         <iframe width="800" height="600" src="https://www.youtube.com/embed/8dJyRm2jJ-U?autoplay=1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
      </div>
   
   <% } else if(title.equals("sel2")) { %>
      <div align="center">
         <h2>선택하신 앨범 정보</h2>
         <hr>
         <p>
            당신이 선택하신 앨범은 BIGBANG (빅뱅)의 <strong>봄여름가을겨울 (Still Life)</strong> 입니다.
         </p>
         <hr>
         <h3>타이틀 곡 뮤직 비디오</h3>
         <iframe width="800" height="600" src="https://www.youtube.com/embed/eN5mG_yMDiM?autoplay=1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
      </div>
   
   <% } %>
  
  
  
  
  
</body>
</html>
