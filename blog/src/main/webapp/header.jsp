<%@page import="model.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/blog/css/header.css">
</head>
<body>
	<div class="wrap">
		<div class="header_wrap">
			<div class="container">

				<!-- 세션호출하기 -->
				<!--	//로그인을 했는지 판단하기 위해 호출함?
				//세션호출 할 때 request.getSession().getAttribute("세션변수명")  -->

				<%String loginid = (String) session.getAttribute("cy_id");%>
				
				<%String cy_name = MemberDao.getInstance().getcy_name( loginid ) ;%>

				<ul class="header_top_ul">
					<!-- loginid가 null이면 로그인을 하지 않았다. -->
					<%
					if (loginid == null) {
					%>
					<li class="header_top_li"><a href="/blog/member/login.jsp">로그인</a></li>
					<li class="header_top_li"><a href="/blog/member/signup.jsp">회원가입</a></li>

					<!-- 세션이 존재한다는다. 로그인을 했다. -->
					<% } else { %>
					<li class="header_top_li"><%=cy_name%> 님 반갑습니다! :)</li>
					<li class="header_top_li"><a href="/blog/member/logout.jsp">로그아웃</a></li>
					<li class="header_top_li"><a href="/blog/member/myinfor.jsp">마이페이지</a></li>
					<% } %>
					<li class="header_top_li"><a href="javascript:void(0)">이웃목록</a></li>
					<li class="header_top_li"><a href="javascript:void(0)">어쩌고저쩌고</a></li>
				</ul>
				<!-- header_top_ul -->

				<div class="main_header">
					<div class="logo_section">
						<a href="/blog/main.jsp">
							<img src="/blog/img/logo/logo.png" alt="logoimg" >
						</a>
					</div>

					<div class="search_section">
						<span class="search_section_span">
							<input type="text" class="search_input">
						</span>						
						<button type="button" class="search_btn">검색하기</button>
					</div>
				</div><!-- main_header -->

			</div><!-- container -->
		</div><!-- header_wrap -->

	</div><!-- wrap -->
	
	<!-- jquery  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script type="text/javascript" src="/blog/js/header.js"></script>
	
	
	
</body>
</html>