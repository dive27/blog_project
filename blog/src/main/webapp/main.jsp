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
 	
	<% 
		//만약에 로그인을 하지 않았으면 로그인페이지로 보내버림
		if(loginid == null) { response.sendRedirect("/blog/member/login.jsp");}
	%> 



	<div class="wrap">
		<!-- ////////////////////////내 정보 영역////////////////////////// -->
		<div class="infor_wrap">

			<div class="infor_box">
			
				<div class="my_infor">

					<div class="profile_img">
						<img class="cy_profile_img" alt="profileimg" src="/blog/img/profileimg/my_profile_img.jpg">
					</div><!-- profile_img -->
					

					<div class="my_blog_name">
						<%=loginid%> 님의 블로그
					</div><!-- my_blog_name -->
					

				</div><!-- my_infor -->
				
				<div class="visit_num_box"><!-- 방문자수  -->
					
					<div class="today_box num_box">
						<span class="num_text">Today</span> <span class="num">0</span>
					</div>

					<div class="total_box num_box">
						<span class="num_text">Total</span> <span class="num">0</span>
					</div>
				</div><!-- visit_num_box -->
				

				<div class="my_blog_visit">
					<a href="/blog/index.jsp">내 블로그 가기</a>
				</div><!-- my_blog_visit -->
				

			</div><!-- infor_box -->
			
			
			<!-- ////////////////////////팔로우 요청영역////////////////////////// -->
			<h5 class="follower_h5"><%=loginid%> 님의 이웃 친구들 입니다.</h5>
			<div class="follower_wrap section">				
				
				<div class="my_follower_list">
				
					<div class="follower">
						<div class="follower_profile_img">
							<img alt="" src="">
						</div><!-- follower_profile_img -->
						<div class="follower_name">이젠컴퓨터 공식 블로그</div>
					</div><!-- follower -->
					
					<div class="follower">
						<div class="follower_profile_img">
							<img alt="" src="">
						</div><!-- follower_profile_img -->
						<div class="follower_name">나는야 개발자</div>
					</div><!-- follower -->
					
					<div class="follower">
						<div class="follower_profile_img">
							<img alt="" src="">
						</div><!-- follower_profile_img -->
						<div class="follower_name">프론트엔드 개발자</div>
					</div><!-- follower -->					
					
					
					<div class="follower">
						<div class="follower_profile_img">
							<img alt="" src="">
						</div><!-- follower_profile_img -->
						<div class="follower_name">날아라 백엔드</div>
					</div><!-- follower -->
					
					<div class="follower">
						<div class="follower_profile_img">
							<img alt="" src="">
						</div><!-- follower_profile_img -->
						<div class="follower_name">이름없음</div>
					</div><!-- follower -->					
					
					<div class="follower">
						<div class="follower_profile_img">
							<img alt="" src="">
						</div><!-- follower_profile_img -->
						<div class="follower_name">이름없음</div>
					</div><!-- follower -->
					
					<div class="follower">
						<div class="follower_profile_img">
							<img alt="" src="">
						</div><!-- follower_profile_img -->
						<div class="follower_name">이름없음</div>
					</div><!-- follower -->
					
					<div class="follower">
						<div class="follower_profile_img">
							<img alt="" src="">
						</div><!-- follower_profile_img -->
						<div class="follower_name">이름없음</div>
					</div><!-- follower -->
					
					<div class="follower">
						<div class="follower_profile_img">
							<img alt="" src="">
						</div><!-- follower_profile_img -->
						<div class="follower_name">이름없음</div>
					</div><!-- follower -->
					
					<div class="follower">
						<div class="follower_profile_img">
							<img alt="" src="">
						</div><!-- follower_profile_img -->
						<div class="follower_name">이름없음</div>
					</div><!-- follower -->
					
				</div><!-- my_follower_list -->


			</div><!-- follower_wrap -->
			
			
			<!-- //////////////////////////////////////////////////////////////////////// -->
			
			
			
			
			
			
			<!-- ////////////////////////블로그 공지사항 영역////////////////////////// -->
			<h2>공지사항</h2>
			<div class="admin_wrap section">			
				
				<div class="admin_infor">

					<div class="admin_img">
						<img alt="" src="">
					</div><!-- admin_img -->
					

					<div class="admin_name">
						<p>블로그이름 공식 블로그<p>
						<span class="date_time"> 30분 전</span><!-- 업데이트 한 시간 -->
					</div><!-- admin_name -->
					

				</div><!-- admin_infor -->
				
				<div class="admin_notice">
				
					<h5 class="text_title">블로그 전제 점검 안내</h5>
					<span class="admin_text"> 
							안녕하세요 &lt;블로그이름 관리자 입니다.&gt; 입니다. 2022년 11월 8일 자정부터 오전 8시까지 전체적인 점검이 있을 예정 입니다. 
							이 시간에는 블로그 이용이 불가능 합니다. 이용자 여러분의 양해 부탁드립니다 감사합니다.
					</span><!-- admin_text -->
					
				</div><!-- admin_notice -->
				
			</div><!-- admin_wrap -->
			
			<!-- //////////////////////////////////////////////////////////////////////// -->
			
			<!-- ////////////////////////친구 소식들 영역////////////////////////// -->
			<h2>최근 내 이웃소식</h2>
			<div class="friend_news_wrap section">
				
				<div class="friend_news">

					<div class="front_info">

						<div class="intro_section">
							<div class="friend_profile_img"><!-- 친구 프로필 이미지 영역 -->								
								<img alt="pfofileimg" src="/blog/img/profileimg/friend_profile_img.png">
							</div><!-- friend_profile -->
							

							<div class="info_author">
								<span class="friend_name">홍길동</span><!-- 친구 이름 -->
								
								<span class="date_time"> 1시간 전</span><!-- 업데이트 한 시간 -->
								
							</div><!-- info_author -->
							

						</div><!-- intro_section -->
						

						<div class="main_title"><!-- 글의 타이틀 -->							
							<h5 class="text_title">안산 디저트 맛집</h5>
						</div><!-- main_title -->
						
						<div class="sub_title">
							<span class="sub_title_text"> <!-- 글 내용 (일부만) --> 
								안녕하세요 홍길동 입니다. 오늘 안산 디저트 맛집을 소개해 드리려고 합니다~~ 여러분들은
							</span><!-- sub_title_text -->
							
						</div><!-- sub_title -->
						

					</div><!-- front_info -->

					<div class="title_img_section"><!-- 글의 메인사진 한장만 -->						
						<img alt="" src="/blog/img/dessert/coffee.jpg">
					</div><!-- title_img_section -->
					
				</div><!-- friend_news -->				
			</div><!-- friend_news_wrap -->
		</div><!-- infor_wrap -->		
	</div><!-- wrap -->
	
	<script type="text/javascript" src="/blog/js/member/main.js"></script>
	
	<%@include file="../footer.jsp"%>


</body>
</html>