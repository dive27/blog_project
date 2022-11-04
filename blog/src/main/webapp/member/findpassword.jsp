<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/blog/css/member/findpassword.css">
</head>
<body>

	<div class="wrap">

		<div class="logo_section">
			<span>로고가 들어갈 예정</span>
		</div>
		<!-- logo_section -->
		<div class="password_wrap">
			<div class="findps_section">
				<div class="find_box">
					<span class="text_box">아이디</span>
				 	<span class="span_box"> 
				 		<input type="text" class="inputbox" id="cy_id">
					</span>
				</div><!-- find_box -->

				<div class="find_box">
					<span class="text_box">이메일</span> 
					<span class="span_box"> 
						<input type="text" class="inputbox" id="cy_email">
					</span>
				</div><!-- <!-- find_box -->
			</div><!-- findps_section -->



			<div class="findpsbox"></div>
			<!-- 비밀번호 나오는 구간 -->

			<button type="button" onclick="findpassword()" class="findbtn">비밀번호 찾기</button>
			<ul class="find_ul">
				<li><a href="/blog/member/login.jsp">로그인하기</a></li>
				<li><a href="/blog/member/findid.jsp">아이디찾기</a></li>
			</ul>
			<!-- find_ul -->
		</div>
		<!-- password_wrap -->
	</div>
	<!-- wrap -->










	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/blog/js/member/findpassword.js"></script>
</body>
</html>