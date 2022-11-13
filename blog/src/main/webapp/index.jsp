<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Index페이지 </title>

	<!-- 사용자정의 css 호출 -->
	<link  rel="stylesheet" href="/blog/css/index.css">
	
	<!-- 뷰포트 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<!-- 폰트어썸[ 아이콘 ] -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
	
	
</head>
<body>



	<%@include file="../header.jsp" %>


	<% 
		//만약에 로그인을 하지 않았으면 로그인페이지로 보내버림
		if(loginid == null) { response.sendRedirect("/blog/member/login.jsp");}
	%> 

	<!-- 성지혜 : 헤더페이지  -->
		<!-- <a>태그 class="nav-link" 추가해서 부트스트랩 적용제외 -->
	
		<div class="webbox"> <!-- 웹페이지 박스권 -->

		<div class="hd_menu"> <!-- 하단 헤더 -->
			<div class="h_menu">
				<div class="profilebox">
					<!-- 프로필 box -->

					<div class="p_title">
						<!-- 자기소개 타이틀 박스 -->
						<span> ABOUT ME </span>
					</div>
					
					<div class="about_me">
						<!-- 자기소개 이미지, 내용 박스 -->
						<div class="profileimg">
							<!-- 상단 메뉴 : 이미지 -->
							<img alt="" src="" class="profile_img">
						</div>
						<div class="profilename">
							<span class="my_name"> <%=cy_name%> 의 블로그 입니다. </span><br> 
							<p class="self_introduction"> 자기소개가 없습니다.<br> 자기소개를 작성해주세요! </p>
							<span>자기소개 수정하기</span>
							<!-- 방문자 수 기록 코드 작성 칸 -->
						</div>
						<div> 
						<a href="#ex1" rel="modal:open">프로필사진변경</a> <br>
						<a href="#ex2" rel="modal:open">이웃신청</a>
						</div>

						<!-- 프로필이름 end -->
					</div>
				</div>
				<!-- 프로필박스 end -->


				<div class="categorybox"> <!-- 카테고리 box -->

							<div class="p_title">
								<span> 카테고리 </span>

							</div>
							<div class="categorylist"> <!-- 카테고리 목록 리스트 -->
								<div class="clist"> <!-- 첫번재 카테고리  -->
									<span class="day"> Updated news </span>
									<ul>

										<li><a class="nav-link" onclick="pagechange('/blog/updated_news/1.new/best.jsp')"> ♡BEST </a></li>
										<li><a class="nav-link" href="#"> 05 </a></li>
										<li><a class="nav-link" href="#"> 06 </a></li>
										
									</ul>
								</div>
								
								<div class="clist"> <!-- 두번재 카테고리  -->
									<span class="day"> 일상 </span>
									<ul>
										<li><a class="nav-link" onclick="pagechange('/blog/board/tlist.jsp')"> ♡게시판 </a></li>
									    <li><a class="nav-link" onclick="pagechange('/blog/gallery/plist.jsp')"> ♡갤러리 </a></li>
									    <li><a class="nav-link" onclick="pagechange('/blog/diary/Diary2.jsp')"> ♡다이어리 </a></li>
									</ul>
								</div>

				                 </div> <!-- 카테고리 리스트 end -->
							 </div> <!-- 카테고리 박스 end -->
								
							<div class="sns_box"> <!-- sns box 전체-->
									<div class="p_title"> <!-- sns 제목 -->
										<span> SNS </span>
									</div>
									<div class="about_me_sns1">
										<div class="sns">												<!-- <i class="fas fa-shopping-cart"></i> -->
											<a class="nav-link" href="https://www.instagram.com/"> <i class="fas fa-brands fa-instagram"></i> instagram </a>
										</div>
										<div class="sns">
											<a class="nav-link" href="https://www.facebook.com/facebook/"> <i class="fas fa-brands fa-facebook"></i> facebook </a>
										</div>
									</div>	
									<div class = "about_me_sns2">
										<div class="sns">
											<a class="nav-link" href="https://twitter.com/"> <i class="fa-brands fa-twitter"></i> twitter </a>
										</div>
										<div class="sns">
											<a class="nav-link" href="https://www.youtube.com/index"> <i class="fa-brands fa-youtube"></i> youtube </a>
										</div>
									</div>
							</div> <!-- sns box end-->

					</div>
				</div> <!-- 하단헤더 end -->

        <div class="mainbox"></div>


		</div> <!-- 웹페이지 박스 end -->
		
		
	
			<!-- 프로필 이미지 변경하는 div 모달 -->
			<div id="ex1" class="modal" style="width: 800px; height: 500px;">
			  <p>프로필변경</p>
			  
			  <!--  프로필 미리 보기 있으면 좋음  -->
			  <!-- 11/11 시도중 예은 -->
			  <div class="change_profile_div">
			  
			  	<img alt="" src="" class="change_profile_img" style="width:50%; margin:0 auto;">
			  </div>
			  
			  <!--  -->			  
			  
			  <form class="form1">
			  	<input type="file" name="cy_profile_img">
			  	<button type="button" class="imgadd">등록</button>
			  </form>
			</div><!-- Link to open the modal -->
			
			


			<!-- 이웃신청 하는  div 모달   div에 있는 id 와 버튼에 있는 <a href="#id"> 일치 해야합니다  -->
			<div id="ex2" class="modal" style="width: 800px; height: 500px;">
			  <p>이웃신청</p>
			  <form>
			  	<input type="text" class="cy_id"> <br>
			  	<textarea rows="10" cols="30" class="cy_follow_message"></textarea> <br>
			  	<button type="button" class="followadd">이웃신청</button>
			  </form>
			</div><!-- Link to open the modal -->			
	
	
	
	<!-- JQUERY 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	

	<!-- 사용자지정 JS -->
	<script type="text/javascript" src="/blog/js/tindex.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
	<link  rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
	

	

</body>
</html>