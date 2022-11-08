<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/blog/css/member/main.css">
</head>
<body>
	<%@include file="../header.jsp"%>
<%-- 	
	<% 
		//만약에 로그인을 하지 않았으면 로그인페이지로 보내버림
		if(loginid == null) { response.sendRedirect("login.jsp");}
	%> 
--%>


	<div class="wrap">
		<!-- ////////////////////////내 정보 영역////////////////////////// -->
		<div class="infor_wrap">

			<div class="infor_box">
			
				<div class="my_infor">

					<div class="profile_img">
						<img alt="" src="">
					</div><!-- profile_img -->
					

					<div class="my_blog_name">
						<%=loginid%> 님의 블로그
					</div><!-- my_blog_name -->
					

				</div><!-- my_infor -->
				
				<div class="visit_num_box"><!-- 방문자수  -->
					
					<div class="  today_box num_box">
						<span class="num_text ">Today</span> <span class="num">10</span>
					</div>

					<div class="total_box num_box">
						<span class="num_text ">Total</span> <span class="num">169</span>
					</div>
				</div><!-- visit_num_box -->
				

				<div class="my_blog_visit">
					<a href="/blog/index.jsp">내 블로그 가기</a>
				</div><!-- my_blog_visit -->
				

			</div><!-- infor_box -->
			<!-- ////////////////////////내 소식 영역////////////////////////// -->



			<!-- ////////////////////////친구 소식들 영역////////////////////////// -->


			
			<div class="friend_news_wrap">
				<h2>최근 내 이웃소식</h2>
				<div class="friend_news">

					<div class="front_info">

						<div class="intro_section">
							<div class="friend_profile_img"><!-- 친구 프로필 이미지 영역 -->								
								<img alt="" src="">
							</div><!-- friend_profile -->
							

							<div class="info_author">
								<span class="friend_name">홍길동</span><!-- 친구 이름 -->
								
								<span class="date_time"> 1시간 전</span><!-- 업데이트 한 시간 -->
								
							</div><!-- info_author -->
							

						</div><!-- intro_section -->
						

						<div class="main_title"><!-- 글의 타이틀 -->							
							<h3>안산 디저트 맛집</h3>
						</div><!-- main_title -->
						
						<div class="sub_title">
							<span class="sub_title_text"> <!-- 글 내용 (일부만) --> 달달하거
								먹고싶어달달하거 먹고싶어달달하거 먹고싶어달달하거 먹고싶어달달하거 먹고싶어달달하거 먹고싶어달달하거 먹고싶어달달하거
								먹고싶어달달하거 먹고싶어 달달하거 먹고싶어달달하거 먹고싶어달달하거 먹고싶어달달하거 먹고싶어달달하거 먹고싶어달달하거
								먹고싶어달달하거 먹고싶어달달하거 먹고싶어달달하거 먹고싶어 달달하거 먹고싶어달달하거 먹고싶어달달하거 먹고싶어달달하거
								먹고싶어달달하거 먹고싶어달달하거 먹고싶어달달하거 먹고싶어달달하거 먹고싶어달달하거 먹고싶어
							</span><!-- sub_title_text -->
							
						</div><!-- sub_title -->
						

					</div><!-- front_info -->

					<div class="title_img_section"><!-- 글의 메인사진 한장만 -->						
						<img alt="" src="">
					</div><!-- title_img_section -->
					
				</div><!-- friend_news -->				
			</div><!-- friend_news_wrap -->
		</div><!-- infor_wrap -->		
	</div><!-- wrap -->
	
	<%@include file="../footer.jsp"%>


</body>
</html>