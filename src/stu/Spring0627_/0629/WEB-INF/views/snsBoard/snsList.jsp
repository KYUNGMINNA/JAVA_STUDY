﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>    
 
<!DOCTYPE html>
<html>
<head>

	<style type="text/css">
	section {
		margin-top: 70px;
	}
	
	/*부트스트랩 li의 drophover클래스 호버시에 드롭다운 적용코드*/
	ul.nav li.drophover:hover>ul.dropdown-menu {
		display: block;
		margin: 0;
	}
	
	.aside-inner {
		position: fixed;
		top: 70px;
		width: 180px;
	}
	
	.section-inner {
		border-right: 1px solid #ddd;
		border-left: 1px solid #ddd;
		background-color: white;
	}
	
	.section-inner p, .aside-inner p {
		margin: 0;
	}
	
	.title-inner {
		position: relative;
		padding: 15px 0;
	}
	
	.title-inner .profile {
		position: absolute; /*부모기준으로 위치지정 릴레이티브*/
		top: 15px;
		left: 0;
	}
	
	.title-inner .title {
		padding-left: 50px;
	}
	/*내용*/
	.content-inner {
		padding: 10px 0;
	}
	/* 이미지영역  */
	.image-inner img {
		width: 100%;
	}
	/*좋아요*/
	.like-inner {
		padding: 10px 0;
		border-bottom: 1px solid #ddd;
		border-top: 1px solid #ddd;
		margin-top: 10px;
	}
	
	.like-inner img {
		width: 20px;
		height: 20px;
	}
	
	.link-inner {
		overflow: hidden;
		padding: 10px 0;
	}
	
	.link-inner a {
		float: left;
		width: 33.3333%;
		text-align: center;
		text-decoration: none;
		color: #333333;
	}
	
	.link-inner i {
		margin: 0 5px;
	}
	
	/*767미만 사이즈에서 해당 css가 적용됨*/
	/*xs가 767사이즈   */
	@media ( max-width :767px) {
		aside {
			display: none;
		}
	}
	/* 파일업로드 버튼 바꾸기 */
	.filebox label {
		display: inline-block;
		padding: 6px 10px;
		color: #fff;
		font-size: inherit;
		line-height: normal;
		vertical-align: middle;
		background-color: #5cb85c;
		cursor: pointer;
		border: 1px solid #4cae4c;
		border-radius: none;
		-webkit-transition: background-color 0.2s;
		transition: background-color 0.2s;
	}
	
	.filebox label:hover {
		background-color: #6ed36e;
	}
	
	.filebox label:active {
		background-color: #367c36;
	}
	
	.filebox input[type="file"] {
		position: absolute;
		width: 1px;
		height: 1px;
		padding: 0;
		margin: -1px;
		overflow: hidden;
		clip: rect(0, 0, 0, 0);
		border: 0;
	}
	
	/* sns파일 업로드시 미리보기  */
	.fileDiv {
		height: 100px;
		width: 200px;
		display: none;
		margin-bottom: 10px;
	}
	
	.fileDiv img {
		width: 100%;
		height: 100%;
	}
	/* 모달창 조절 */
	.modal-body {
		padding: 0px;
	}
	
	.modal-content>.row {
		margin: 0px;
	}
	
	.modal-body>.modal-img {
		padding: 0px;
	}
	
	.modal-body>.modal-con {
		padding: 15px;
	}
	
	.modal-inner {
		position: relative;
	}
	
	.modal-inner .profile {
		position: absolute; /*부모기준으로 위치지정 릴레이티브*/
		top: 0px;
		left: 0px;
	}
	
	.modal-inner .title {
		padding-left: 50px;
	}
	
	.modal-inner p {
		margin: 0px;
	}
	</style>
	
</head>
<body>
	<%@ include file="../include/header.jsp" %>
	<section>
		<div class="container">
			<div class="row">
				<aside class="col-sm-2">
					<div class="aside-inner">
						<div class="menu1">
							<c:choose>
								<c:when test="${login !=null}">
						
									<p>
										<img src="../resources/img/profile.png">&nbsp;&nbsp;${login.userName}님
									</p>
									<ul>
										<li>내정보</li>
										<li>내쿠폰</li>
										<li>내좋아요게시물</li>
									</ul>
								</c:when>
								<c:otherwise>
									<button type="button" class="btn btn-info" onclick="location.href='<c:url value="/user/userLogin"/>'">로그인</button>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="menu2">
							<p>둘러보기</p>
							<ul>
								<li>기부 캠페인</li>
								<li>페이지</li>
								<li>그룹</li>
								<li>이벤트</li>
								<li>친구리스트</li>
							</ul>
						</div>
					</div>
				</aside>
				<div class="col-xs-12 col-sm-8 section-inner">
					<h4>게시물 만들기</h4>
					<!-- 파일 업로드 폼입니다 -->
					<div class="fileDiv">
						<img id="fileImg" src="<c:url value='/img/img_ready.png'/>">
					</div>
					<div class="reply-content">
						<textarea class="form-control" rows="3" name="content"
							id="content" placeholder="무슨 생각을 하고 계신가요?"></textarea>
						<div class="reply-group">
							<div class="filebox pull-left">
								<label for="file">이미지업로드</label> 
								<input type="file" name="file" id="file">
							</div>
							<button type="button" class="right btn btn-info" id="uploadBtn">등록하기</button>
						</div>
					</div>


					<!-- 파일 업로드 폼 끝 -->
					<div id="contentDiv">
					
					<!-- 비동기 방식으로 서버와 통신을 진행한 후 목록을 만들어서 붙일 영역  -->
					</div>
				</div>
				
				
				<!--우측 어사이드-->
				<aside class="col-sm-2">
					<div class="aside-inner">
						<div class="menu1">
							<p>목록</p>
							<ul>
								<li>목록1</li>
								<li>목록2</li>
								<li>목록3</li>
								<li>목록4</li>
								<li>목록5</li>
							</ul>
						</div>
					</div>
				</aside>
			</div>
		</div>
	</section>
	<%@ include file="../include/footer.jsp" %>
	<!-- 모달 -->
	<div class="modal fade" id="snsModal" role="dialog">
			<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-body row">
					<div class="modal-img col-sm-8 col-xs-6" >
						<img src="../resources/img/img_ready.png" id="snsImg" width="100%">
					</div>
					<div class="modal-con col-sm-4 col-xs-6">
						<div class="modal-inner">
						<div class="profile">
							<img src="../resources/img/profile.png">
						</div>
						<div class="title">
							<p id="snsWriter">테스트</p>
							<small id="snsRegdate">21시간전</small>
						</div>
						<div class="content-inner">
							<p id="snsContent">삶이 우리를 끝없이 시험하기에 고어텍스는 한계를 테스트합니다</p>
						</div>
						<div class="link-inner">
							<a href="##"><i class="glyphicon glyphicon-thumbs-up"></i>좋아요</a>
							<a href="##"><i class="glyphicon glyphicon-comment"></i>댓글달기</a> 
							<a href="##"><i class="glyphicon glyphicon-share-alt"></i>공유하기</a>
						</div>
						
						
						
						
						
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>




	<script>
		
		$(function(){
			
			
			//등록하기 버튼 클릭 이벤트 
			$('#uploadBtn').click(function(){
				regist();
				
				
				
			});//등록 이벤트 끝 
			
			
			//등록을 담당하는 함수 
			function regist(){
				//세션에서 현재 로그인 중인 사용자 정보 (아이디)를 얻어 오자 
				const user_id='${sessionScope.login.userId}';
				//자바스크립트의 파일 확장자 체크 검색
				let file=$('#file').val();
				
				console.log(user_id);
				console.log(file);
				//.을 제거한 확장자만 얻어낸 후 그것을 소문자로 일괄 변경 
				file=file.slice(file.indexOf('.')+1).toLowerCase();
				console.log(file);
				if(file !== 'jpg' && file !=='png' && file !=='jpeg' && file !=='bmp'){
					alert('이미지 파일(jpg , png , jpeg , bmp )만 등록이 가능합니다.');
					$('#file').val('');
					return;
				}else if(user_id ===''){ //세션 데이터가 없다 = 로그인 X
					alert('로그인이 필요한 서비스 입니다.');
					return;
					
				}
				
				
				//ajax 폼 전송의 핵심 FormData 객체  :form이 없는데 ,form으로 감싸서 보내기(서버로 보내기)
				const formData=new FormData();
				const data=$('#file'); // id로 접근해서 하나만 접근가능하지만 , input[type=file] 이런식으로 접근하면 여러개 가져옴
																	//data[0] .data[1] .. 이런식으로 접근 버튼 접근가능하며
																	//만약 버튼중 하나가 여러개 파일전송이면 data[1].files[6] 접근				
				console.log('폼 데이터 : '+formData);
				console.log('data :'+data);
				console.log(data[0]); //input type="file"  요소를 지목 할 때 사용 
				console.log(data[0].files);  //파일 태그에 담긴 파일 정보를 확인하는 키값 (file name, lastModified 등 등 여러 정보)
				
				console.log(data[0].files[0]);//사용자가 등록한 최종 파일 정보 
				
				/*
				data[index] -> 파일 업로드 버튼이 여러개 존재 할 경우 요소의 인덱스를 지목해서 가져오는 방법
				우리는 요소를 id로 취득했기 때문에 하나만 찍히지만 , 추후에 class 이름같은 걸로 지목을 하면 여러 개가 취득
				
				files[index] -> 파일이 여러개 전송되는 경우, 몇번 째 파일인지를 지목
				우리는 지금 multiple속성을 주지 않았기 때문에 , 0번 인덱스 밖에 없는것 
				
				*/
				
				//FormData 객체에 사용자가 업로드한 파일의 정보가 들어있는 객체를 전달 
				formData.append('file',data[0].files[0]);
				//formData.append('file',data[0].files[1]); 여러개면 이런식으로 작성한다 .
				//formData.append('file',data[0].files[2]);
				
				//content(글 내용) 값을 얻어와서 폼 데이터에 추가 
				const content=$('#content').val();
				formData.append('content',content);  // (파라미터 변수명 , 넣을 데이터)
				
				//비동기 방식으로 파일 업로드 및 게시글 등록 진행
				$.ajax({ 
					url:'<c:url value="/snsBoard/upload"/>',
					type:'post',
					data:formData,//폼 데이터 객체를 넘깁니다,
					contentType:false, //ajax 방식에서 파일을 넘길때는 반드시 false로 처리해야 ->"multipart/form-data"로 선언됨.
					processData:false, //폼 데이터를   &변수=값 &변수=값 .. 형식으로 변경되는걸 막음 
					success:function(result){
						if(result ==='success'){
							$('#file').val('');//파일 선택지 비우기 
							$('#content').val(''); //글 영역 비우기
							$('.fileDiv').css('display','none'); //미리보기 감추기
							getList(1,true);//글 목록 함수 호출-true=reset
						}else{
							alert('업로드에 실패 .관리자에게 문의 ');
						}
					},
					error:function(request,status,error){
						console.log('code :'+request+'\n message:'+request.responseText+"\n"+'error :'+error);
						alert('업로드에 실패 .관리자에게 문의 ');
						
					}
				}); //end ajax
				
			}//end regist()
			
			
			//리스트 작업 
			let str='';
			let page=1;
			getListLike(true).done(getList); //getListLike 함수가 끝나면 , getList 함수를 호출하라는 의미  :Deferred객체가 도와줌 
			
			
			//지금 게시판에 들어온 회원의 좋아요 게시물 목록을 받아오는 함수 
			function getListLike(isReset){
				let deferred=$.Deferred(); //비동기 방식으로 데이터를 불러올때 , 함수의 순서를 정해주는 함수 - 먼저 실행할곳에 생성 해주면됨
											//비동기에서 실행 순서를 정하기 위함 
				
				console.log('먼저 실행되어야 합니다.'); //getList보다 먼저 실행되어야 함 
				
				const userId='${login.userId}'; //세션에서 얻어옴
				console.log(userId);
				
				if(userId !==''){
					$.ajax({
						type:'post',
						url:'<c:url value="/snsBoard/listLike" />',
						data:userId,
						contentType:'application/json',
						success:function(result){
							console.log('result : '+result); //게시글 번호들 (배열의 형태)
							
							if(isReset){
							deferred.resolve(result,page,true); //괄호 안에 전달하고 싶은 값 작성
											//콜백방식으로 매개값 저장(즉 ,이 값은 getList 함수의 매개값))
							}else{
								deferred.resolve(result,page,false); //괄호 안에 전달하고 싶은 값 작성
										//result는 서버에서 전달받은 값 , page 는 전역변수 
							}
						},
						error:function(){
							
						}
						
						
					}); //end ajax
				}else{
					if(isReset){
						deferred.resolve(null,page,true); //괄호 안에 전달하고 싶은 값 작성 :
							
						}else{
							deferred.resolve(null,page,false); //괄호 안에 전달하고 싶은 값 작성
								
						}
					
				}
				
				return deferred.promise(); //순서를 준수할 수 있도록 함
			}
			
			
			
			
			function getList(data,page,reset){
				if(reset ===true){
					str=''; //화면 리셋 여부가 true라면  str변수를 초기화
					
				}
				$.getJSON(//get 방식 전용으로 비동기 방식으로 통신!
					'<c:url value="/snsBoard/getList?pageNum='+page+'"/>',
					function(list){
						console.log(list);
						
						
						for(let i=0;i<list.length;i++){
							str+=						
							`<div class="title-inner">
							<!--제목영역-->
							<div class="profile">
								<img src="<c:url value='/img/profile.png'/>">
							</div>
							<div class="title">
								<p>`+list[i].writer+`</p>
								<small>`+timeStamp(list[i].regdate)+`</small> &nbsp;&nbsp;
								<a href="<c:url value='/snsBoard/download?fileLoca=`+list[i].fileloca+`&fileName=`+list[i].filename+`'/>">이미지 다운로드</a>
							</div>
						</div>
						<div class="content-inner">
							<!--내용영역-->
							<p>`+(list[i].content ===null? '' : list[i].content)+`</p>
						</div>
						<div class="image-inner">
							<!-- 이미지영역                서버에 URL로 요청을 보내는것 -->
							<a href="`+list[i].bno+`">
							<img src="<c:url value='/snsBoard/display?fileLoca=`+list[i].fileloca+`&fileName=`+list[i].filename+`' />">
							</a>
						</div>
						<div class="like-inner">
							<!--좋아요-->
							<img src="../resources/img/icon.jpg"> <span>`+list[i].likeCnt+`</span>
						</div>
						<div class="link-inner">`;
							if(data !=null){
								if(data.includes(list[i].bno)){
									str+=`<a id="likeBtn" href="`+list[i].bno+`"><img src="${pageContext.request.contextPath}/img/like2.png" width="20px" height="30px">좋아요</a>`;
								}else{
									str+=`<a id="likeBtn" href="`+list[i].bno+`"><img src="${pageContext.request.contextPath}/img/like1.png" width="20px" height="30px">좋아요</a>`;
								}
							}else{
								str+=`<a id="likeBtn" href="`+list[i].bno+`"><img src="${pageContext.request.contextPath}/img/like1.png" width="20px" height="30px">좋아요</a>`;
							}
							str+=`
							
							
							<a id="comment" href="`+list[i].bno+`"><i class="glyphicon glyphicon-comment"></i>댓글달기</a> 
							<a id="delBtn" href="`+list[i].bno+`" id=""><i class="glyphicon glyphicon-remove"></i>삭제하기</a>
						</div>`;
						$('#contentDiv').html(str);
						
						
						}//end for 
										
					} 
					
				); //end getJSON
				
				
				
				
				
				
				
				
			}//end getList
			
			
			
			//상세보기 처리(모달창 열어줄 겁니다)
			$('#contentDiv').on('click','.image-inner a, .link-inner #comment',function(e){
				e.preventDefault(); //a의 고유 기능 중지
				
				//글 번호 얻어오기
				const bno=$(this).attr('href');
				
				$.getJSON(
					'<c:url value="/snsBoard/getDetail/"/>'+bno,
					function(data){
						console.log(data);
						const src='<c:url value="/snsBoard/display?fileLoca='+data.fileloca+'&fileName='+data.filename+'"/>';
						$('#snsImg').attr('src',src);//이미지 겨올 처리
						$('#snsWriter').html(data.writer);  //작성자 처리
						$('#snsRegdate').html(timeStamp(data.regdate)); //날짜 처리 
						$('#snsContent').html(data.content); //내용 처리
						
						
						//미리 준비한 모달창에 뿌릴겁니다 (모달 위에 있어요)
						//값을 제 위치에 잘 뿌리고 ,모달을 열어주세요.
						$('#snsModal').modal('show'); //모달 ㅕㅇㄹ기
					}
				);
				
				
			});//상세보기 처리 끝 
			
			//삭제 처리
		      //삭제하기 링크를 클릭했을 때 이벤트를 발생 시켜서
		      //비동기 방식으로 삭제를 진행해 주세요. (삭제 버튼은 한 화면에 여러개 겠죠?)
		      //서버쪽에서 권한을 확인 해 주세요. (작성자와 로그인 중인 사용자의 id를 비교해서)
		      //일치하지 않으면 문자열 "noAuth" 리턴, 성공하면 "Success" 리턴.
		      // url: /snsBoard/delete, method: post
			$('#contentDiv').on('click','.link-inner #delBtn',function(e){
				e.preventDefault();
				const bno=$(this).attr('href');
			
				
		 		$.ajax({
					url:'<c:url value="/snsBoard/delete"/>',
					type:'post',
					data:bno,
					contentType:'application/json',
					success:function(result){
						if(result ==='noAuth'){
							alert('권한이 없습니다.');
						}else if(result ==='fail'){
							alert('삭제에 실패했습ㄴ디ㅏ. 관리자에게 문의하세요.');
						}else{
							alert('게시물이 정상적으로 삭제되었습니다.');
							getListLike(true).done(getList); //삭제가 반영된 글 목록을 새로벡 보여줘야 하기 대문에 리셋 여부를 true
						}
						
					
					},
					error:function(){
						alert('삭제  실패 .관리자에게 문의 ');
						
					}
					
					
				}); //end ajax 
							
							
							
							
							
			});//삭제 처리 끝
			
			
			//무한 스크롤
			$(window).scroll(function(){
				//윈도우 (device)의 높이와 현재 스크롤 위치 값을 더한 뒤 , 문서(컨텐츠)의 높이와 비교해서 
				//같다면 로직을 수행
				//문서 높이- 브라우저 창 높이 = 스크롤 창의 끝 높이와 같다면 -> 새로운 내용을 불러오자.
				
				if(Math.round($(window).scrollTop())===$(document).height()-$(window).height()){
					//사용자의 스크롤이 바닥에 닿았을 때 , 페이지 변수의 값을 하나 올리고
					//reset 여부는 false를 주는데, 누적해서 계속 불러오기 때문
					//게시글 몇개씩 불러올지는 페이징 알고리즘에서 정해주면 된다.
					page++;
					getListLike(false).done(getList);
				}
				
				
			});
			
			
			//좋아요 기능 구현
			$('#contentDiv').on('click','#likeBtn',function(e){
				e.preventDefault();
				console.log('좋아요 버튼 클릭됨!');
				console.log(e.target);
				
				
				if(e.target.matches('img')){
					$('#likeBtn').click();
					return;
				}
				
				
				const bno=$(this).attr('href');
				const id='${login.userId}'; //현재 로그인 중인 사용자의 아이디 (세션에셔 얻어옴)
				if( id === ''){
					alert('로그인이 필요합니다.');
					return;
				}
				
				$.ajax({
					type:'post',
					url:'<c:url value="/snsBoard/like"/>',
					contentType:'application/json',
					data:JSON.stringify({
						'bno':bno,
						'userId':id
					}),
					success:function(result){
						console.log('result : '+result);
						
						if(result === 'like'){
							e.target.firstChild.setAttribute('src','${pageContext.request.contextPath}/img/like2.png');
							e.target.style.color='blue';
							const $cnt=e.target.parentNode.previousElementSibling.children[1];
							console.log($cnt);
							$cnt.textContent=Number($cnt.textContent)+1;
						
							
							
						}else{
							e.target.firstChild.setAttribute('src','${pageContext.request.contextPath}/img/like1.png');
							e.target.style.color='black';
							const $cnt=e.target.parentNode.previousElementSibling.children[1];
							console.log($cnt);
							$cnt.textContent=Number($cnt.textContent)-1;
						}
						
						
						
					},
					error:function(){
						alert('좋아요 진행 에러 발생!');
					}
					
					
					
				}); //end ajax
					
				
				
			});
			
			
			
			
			
			
			
			
			
			
		});//end Jquery
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		//날짜 처리 함수
        function timeStamp(millis) {
           const date = new Date(); //현재 날짜
           //현재 날짜를 밀리초로 변환 - 등록일 밀리초 -> 시간 차
           const gap = date.getTime() - millis;
           
           let time; //리턴할 시간
           if(gap < 60 * 60 * 24 * 1000) { //1일 미만일 경우
              if(gap < 60 * 60 * 1000) { //1시간 미만일 경우
                 time = '방금 전';
              } else {
                 time = parseInt(gap / (1000 * 60 * 60)) + '시간 전';
              }
           } else { //1일 이상일 경우
              const today = new Date(millis);
              const year = today.getFullYear(); //년
              const month = today.getMonth() + 1; //월
              const day = today.getDate(); //일
              
              time = year + '년 ' + month + '월 ' + day + '일';
           }
           
           return time;         
        }
	
	
		//자바 스크립트 파일 미리보기 기능
		function readURL(input) {
        	if (input.files && input.files[0]) {
        		
            	var reader = new FileReader(); //비동기처리를 위한 파읽을 읽는 자바스크립트 객체
            	//readAsDataURL 메서드는 컨텐츠를 특정 Blob 이나 File에서 읽어 오는 역할 (MDN참조)
	        	reader.readAsDataURL(input.files[0]); 
            	//파일업로드시 화면에 숨겨져있는 클래스fileDiv를 보이게한다
	            $(".fileDiv").css("display", "block");
            	
            	reader.onload = function(event) { //읽기 동작이 성공적으로 완료 되었을 때 실행되는 익명함수
                	$('#fileImg').attr("src", event.target.result); 
                	console.log(event.target)//event.target은 이벤트로 선택된 요소를 의미
	        	}
        	}
	    }
		$("#file").change(function() {
	        readURL(this); //this는 #file자신 태그를 의미
	        
	    });
		
		
		
		
		
		
	</script>
	
	
	
</body>
</html>