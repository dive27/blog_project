<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시판 </title>


</head>
<body>

	<div class="webbox">
		<button type="button" onclick="pagechange('/blog/board/twrite.jsp')">글쓰기</button>
		
		<!-- 5. 게시물수 -->
		<div>게시물수 : <span class="totalsize"></span></div>
		
		<!-- 6. 화면에 표시할 게시물 수 -->
		<div>
			<select class="listsize" onchange="blistsize()">
				<option value="5"> 5 </option>
				<option value="10"> 10 </option>
				<option value="15"> 15 </option>
				<option value="20"> 20 </option>
			</select>
		</div>
		
		<table class="btable table" > <!--  1. 게시물 표시 구역 -->
			
		</table>
		
		<div class="pagebox">	<!-- 3.페이징처리  -->
		
		</div>
		
		<div> <!-- 4. 검색처리 구역 -->
			<select class="key">
				<option value="b.btitle">제목</option>
				<option value="b.bcontent">내용</option>
				<option value="m.mid">작성자</option>
			</select>
			<input class="keyword" type="text" placeholder="검색어">
			<button type="button" onclick="bsearch()">검색</button>
		</div>
	</div>

	<!-- 사용자 js연결 -->
	<script type="text/javascript" src="/blog/js/board/tlist.js"></script>

</body>
</html>