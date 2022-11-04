<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/blog/css/member/findid.css">
</head>
<body>
	<div class="wrap">
		<div class="logo_section">
				<span>로고가 들어갈 예정</span>
		</div>
		
		<div class="findid_wrap">
			<div class="findid_section">
				<div class="find_box">
					<span class="text_box">이름</span> 
					
					<span class="span_box"> 
						<input type="text" class="inputbox" id="cy_name">
					</span>
				</div><!-- find_box -->

				<div class="find_box">
					<span class="text_box">이메일</span> 
					<span class="span_box"> 
						<input type="text" class="inputbox" id="cy_email">
					</span>
				</div><!-- find_box -->

			</div><!-- findid_section -->
			<div class="findidbox"></div><!-- 아이디 나오는 구간 -->

			<button type="button" onclick="findid()" class="findbtn">아이디 찾기</button>
			<ul class="find_ul">
				<li class="find_li"><a href="/blog/member/login.jsp">로그인하기</a></li>
				<li class="find_li"><a href="/blog/member/findpassword.jsp">비밀번호 찾기</a></li>
			</ul>

		</div><!-- findid_wrap -->
	</div><!-- wrap -->

	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/blog/js/member/findid.js"></script>
</body>
</html>