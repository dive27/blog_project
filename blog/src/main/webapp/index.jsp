<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 사용자정의 css 호출 -->
	<link  rel="stylesheet" href="/blog/css/index.css">
	
	<!-- 뷰포트 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<!-- 폰트어썸[ 아이콘 ] -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
	
	
</head>
<body>

	<%@include file="../header.jsp" %>
	
	<!-- 성지혜 : 헤더페이지  -->
		<!-- 게시판 부트스트랩 사용o,	<a>태그 class="nav-link" 추가해서 부트스트랩 적용제외 -->
	
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
							<img alt="" src="/jspweb2/img/초상화.jpg">
						</div>
						<div class="profilename">
							<span> 별명 : 소공녀 </span><br> <span> 소개글 : 하루하루가 너무 행복하다!! </span>

							<!-- 방문자 수 기록 코드 작성 칸 -->

						</div>
<<<<<<< HEAD
						<div class="categorylist"> <!-- 카테고리 목록 리스트 -->
							<div class="clist"> <!-- 첫번재 카테고리  -->
								<span> 일상 </span>
								<ul>
									<li><a class="nav-link" onclick="pagechange('/blog/board/tlist.jsp')"> ♡게시판 </a></li>
									<li><a class="nav-link" onclick="pagechange('/blog/gallery/plist.jsp')"> ♡갤러리 </a></li>
									<li><a class="nav-link" onclick="pagechange('/blog/diary/Diary2.jsp')"> ♡다이어리 </a></li>
								</ul>
=======
						<!-- 프로필이름 end -->
					</div>
				</div>
				<!-- 프로필박스 end -->


				<div class="categorybox"> <!-- 카테고리 box -->
							<div class="category">
								<span> 카테고리 </span>
>>>>>>> branch '11/04_최윤미' of https://github.com/dive27/blog_project
							</div>
							<div class="categorylist"> <!-- 카테고리 목록 리스트 -->
								<div class="clist"> <!-- 첫번재 카테고리  -->
									<span class="day"> 일상 </span>
									<ul>
										<li><a class="nav-link" onclick="pagechange('/blog/board/tlist.jsp')"> ♡게시판 </a></li>
										<li><a class="nav-link" href="#"> ♡갤러리 </a></li>
										<li><a class="nav-link" href="#"> ♡다이어리 </a></li>
									</ul>
								</div>
								<div class="clist"> <!-- 두번재 카테고리  -->
									<span class="day"> 일상 </span>
									<ul>
										<li><a class="nav-link" href="#"> 04 </a></li>
										<li><a class="nav-link" href="#"> 05 </a></li>
										<li><a class="nav-link" href="#"> 06 </a></li>
									</ul>
								</div>
								<div class="clist"> <!-- 세번재 카테고리  -->
									<span class="day"> 맛집 </span>
									<ul>
										<li><a class="nav-link" href="/jspweb2/gallery/latestlist.jsp"> ♡최신글 </a></li>
										<li><a class="nav-link" href="/jspweb2/gallery/food.jsp"> ♡FOOD </a></li>
										<li><a class="nav-link" href="/jspweb2/gallery/dessert.jsp">♡DESSERT </a></li>
									</ul>
								</div>
							</div> <!-- 카테고리 리스트 end -->
						</div> <!-- 카테고리 박스 end -->
						
						<div class="sns_box"> <!-- sns box 전체-->
							<div class="s_title"> <!-- sns 제목 -->
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
				</div> <!-- 목차 end -->
			<div class="mainbox"> </div>
	
	</div> <!-- 웹페이지 박스 end -->

	<!-- 사용자지정 JS -->
	<script type="text/javascript" src="/blog/js/tindex.js"></script>
	
	<!-- JQUERY 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	

</body>
</html>