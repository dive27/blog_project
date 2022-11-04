<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="/blog/css/index.css">
	<!-- 사용자정의 css 호출 -->
	<link  rel="stylesheet" href="/blog/cssboard/index.css">
	
	<!-- 사용자정의 css 호출 -->
	<link  rel="stylesheet" href="/blog/css/board/header.css">
	
</head>
<body>
<%@include file="../header.jsp" %>
	<div class="webbox">	
	
	<div>
			main img 
	</div>
	
	 <div class="hd_menu">
					<div class="profilebox"> <!-- 프로필 box -->
						
						<div class="profileimg"> <!-- 상단 메뉴 -->
							<img alt="" src="/blog/img/emo1.gif">
						</div>
						<div class="profilename">
							<span> 별명 : 꿀꿀이 </span><br>
							<span> 소개글 : 오늘의 날씨 맑음!! </span>
							
							<!-- 방문자 수 기록 코드 작성 칸 -->
							
							
						</div> <!-- 프로필이름 end -->
					</div>	<!-- 프로필박스 end -->
					
					<div class="categorybox"> <!-- 카테고리 box -->
						<div class="category">
							<span> 카테고리 </span>
						</div>
						<div class="categorylist"> <!-- 카테고리 목록 리스트 -->
							<div class="clist"> <!-- 첫번재 카테고리  -->
								<span> 일상 </span>
								<ul>
									<li><a class="nav-link" onclick="pagechange('/blog/board/tlist.jsp')"> ♡게시판 </a></li>
									<li><a class="nav-link" onclick="pagechange('#')"> ♡갤러리 </a></li>
									<li><a class="nav-link" onclick="pagechange('/blog/diary/Diary2.jsp')"> ♡다이어리 </a></li>
								</ul>
							</div>
							<div class="clist"> <!-- 두번재 카테고리  -->
								<span> 일상 </span>
								<ul>
									<li><a class="nav-link" href="#"> 04 </a></li>
									<li><a class="nav-link" href="#"> 05 </a></li>
									<li><a class="nav-link" href="#"> 06 </a></li>
								</ul>
							</div>
							<div class="clist"> <!-- 세번재 카테고리  -->
								<span> 맛집 </span>
								<ul>
									<li><a class="nav-link" onclick="pagechange('/blog/gallery/latestlist.jsp')"> ♡최신글 </a></li>
									<li><a class="nav-link" onclick="pagechange('/blog/gallery/food.jsp')"> ♡FOOD </a></li>
									<li><a class="nav-link" onclick="pagechange('/blog/gallery/dessert.jsp')">♡DESSERT </a></li>
								</ul>
							</div>
						</div> <!-- 카테고리 리스트 end -->
					</div> <!-- 카테고리 박스 end -->
				
		</div> <!-- 목차 end -->
		<div class="mainbox">
						
		</div>
	
				
	 <script type="text/javascript" src="/blog/js/tindex.js"></script>
	 
</div><!-- wrap -->
</body>
</html>