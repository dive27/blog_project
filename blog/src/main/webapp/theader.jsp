<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 사용자정의 css 호출 -->
	<link  rel="stylesheet" href="/blog/css/board/header.css">
	
	<!-- 뷰포트 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<!-- 폰트어썸[ 아이콘 ] -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
	<!-- 부트스트랩 CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>
<body>
	
	<!-- 성지혜 : 헤더페이지  -->
	
	<div class="webbox"> <!-- 웹페이지 박스권 -->
		
			<div class="hd_top"> <!-- 상단 헤더 -->
				<div> <!-- 로고 -->
					<span class="hd_title">
						<a class="nav-link" href="/blog/tindex.jsp"> My 블로그 </a>
					</span>
				</div>
				
				<!-- 세션호출, 형변환 -->
				<%
					String loginid = (String)session.getAttribute("mid");
				%>
				
				<ul class="hd_sub"> <!-- 상단메뉴 -->
				
				<!-- 비로그인 메뉴 // 세션이 없다[ 로그인 안함 ] -->
				<%	if( loginid == null ){	%>
					<li><a href="/blog/member/tlogin.jsp"> 로그인 </a></li>
					<li><a href="/blog/member/tsignup.jsp"> 회원가입 </a></li>
				
				<!-- 로그인메뉴 // 세션이 존대한다.[ 로그인 함 ] -->
				<%	}else{ %>
					<li> <%=loginid %>님 안녕하세요.</li>
					<li><a href="/blog/member/tlogout.jsp"> 로그아웃 </a></li>
				<%	}	%>
					
				<!-- 공통메뉴 -->
					<li><a href="/blog/tindex.jsp"> 내 블로그 </a></li>
					<li><a href="/blog/member/tfirends.jsp"> 이웃 </a></li>
					<li><a href="/blog/member/tmypage.jsp"> 마이페이지 </a></li>
					<li><a href="/blog/board/tlist.jsp"> 게시판 </a></li>
				</ul>
			</div>

				
			<div class="box"> </div>
	
	</div> <!-- 웹페이지 박스 end -->

	<!-- 부트스트랩  -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	
	<!-- JQUERY 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- JQUERY 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	

</body>
</html>