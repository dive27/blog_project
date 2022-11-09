<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> 게시판 </title>

	<!-- 사용자정의 css 호출 -->
	<link  rel="stylesheet" href="/blog/css/board/tlist.css">

</head>
<body>
		<div class="all_list_box"> <!-- 글목록 전체 박스 -->
			<div class="list_sbox">
				<div class="search_box"> <!-- 검색창 전체 박스 -->
					<div class="search_list"> <!-- 검색처리 구역 -->
						
						<select class="key">
							<option value="b.btitle">제목</option>
							<option value="b.bcontent">내용</option>
							<option value="m.mid">작성자</option>
						</select>
						<input class="keyword" type="text" placeholder="검색어">
						<button type="button" onclick="bsearch()">검색</button>
								
								<!-- 6. 화면에 표시할 게시물 수 -->
							<div class="num_list">
								<select class="listsize" onchange="blistsize()">
									<option value="5"> 5 </option>
									<option value="10"> 10 </option>
									<option value="15"> 15 </option>
									<option value="20"> 20 </option>
								</select>
							</div>
						
						
					</div> <!-- 검색처리 구역 end -->
				</div>
				
				<div class="dd"> <!-- 게시물 수 + 글쓰기 박스권 -->
					<div class="dd_box"> <!-- 게시물 수 표현 박스 -->
						<div>
							<div>게시물수 : <span class="totalsize"></span></div>
						</div>
					</div> <!-- 게시물 수 표현 박스 end -->
					
				</div> <!-- 게시물 수 + 글쓰기 박스권 end -->
				
				
				<div class="post_box"> <!-- 게시물표시 전체 박스 -->
					<div class="post_list">
						<table class="btable" >
						</table>
						
					</div> <!-- 게시물표시 전체 박스 end -->
					
				</div> <!-- 게시물표시 전체 박스 end -->
				
				<div class="w_box">
					<button type="button" onclick="pagechange('/blog/board/twrite.jsp')">글쓰기</button>
				</div>
				
				<div class="pagebox">	<!-- 3.페이징처리  -->
					
				</div>

			</div>
		</div>  <!-- 글목록 전체 박스end -->

	
	<!-- JQUERY 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 사용자 js연결 -->
	<script type="text/javascript" src="/blog/js/board/tlist.js"></script>
	
	

</body>
</html>