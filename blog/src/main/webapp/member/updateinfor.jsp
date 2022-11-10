<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/blog/css/member/updateinfor.css">
</head>
<body>
	<%@include file="../header.jsp" %>	
	<% 
		//만약에 로그인을 하지 않았으면 로그인페이지로 보내버림
		if(loginid == null) { response.sendRedirect("login.jsp");}
	%>
	
	<%	
		//int cy_num = Integer.parseInt(request.getParameter("cy_num"));
	
	%>

	<div class="wrap">
		<div class="infor_wrap">
			<h3 class="myinfor_title"></h3>
		
				<table class="infor_table">
					<tr>
						<td class="td_1">회원번호</td>
						<td id="cy_num" class="readonly"></td>
					</tr>

					<tr>
						<td class="td_1">아이디</td>
						<td id="cy_id"  class="readonly"></td>
					</tr>
					<tr>
						<td class="td_1">이름</td>
						<td>
							<span class="infor_span">
								<input type="text" id="cy_name" class="input_box" name="cy_name">
							</span>
							
						</td>
					</tr>
					<tr>
						<td class="td_1">전화번호</td>
						<td>
							<span class="infor_span">
								<input type="text" id="cy_phone" class="input_box" name="cy_phone">
							</span>
						</td>
					</tr>
					<tr>
						<td class="td_1">이메일</td>
						<td>
							<span class="infor_span">
								<input type="text" id="cy_email" class="input_box" name="cy_email">
							</span>
						</td>
					</tr>
					<tr>
						<td class="td_1">가입날짜</td>
						<td id="cy_signuptime"  class="readonly"></td>
					</tr>
				</table>
		

			<div class="btn_section">
				<a href="/blog/member/myinfor.jsp">
				<button type="reset" class="cancelbtn inforbtn">뒤로가기</button></a>
				<button type="button" class="updateinforbtn inforbtn" onclick="updateinforbtn()">수정하기</button>
			</div><!-- btn_section -->
		</div><!-- infor_wrap -->
	</div><!-- wrap -->

	<script src="/blog/js/member/updateinfor.js"></script>

</body>
</html>