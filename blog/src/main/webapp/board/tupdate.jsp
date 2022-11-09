<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시글 수정 </title>
	
	<link rel="stylesheet" href="/blog/css/board/tupdate.css">
</head>
<body>

	<!-- 성지혜 : 게시판 - 수정 페이지 -->

	<div class="webbox">
		<h3 class="webbox_title">게시물 수정</h3>

		<form>
			<div class="update_wrap">
				<div class="b_box">
					<span class="sub_text">제목</span> 
					<span class="input_text">
						<input type="text" name="btitle" class="btitle input">
					</span>
					
				</div>


				<div class="b_box">
					<span class="sub_text">내용</span>
					<span class="input_text">
						<textarea style="resize: none;" name="bcontent" cols="72" rows="20" class="bcontent  input" ></textarea>
					</span>
				</div>

				<div class="b_box">
					<span class="sub_text">첨부파일</span> 
					<input type="file" name="bfile" class="bfile ">
					<span class="input_text">
						
					</span>
				</div>

				<!-- 기존 첨부파일 이름과 삭제버튼 표시 구역 -->
				<div class="oldbfilebox" id="oldbfilebox"></div>

				<div class="btn_section">
					<!-- form 태그 안에서 button 사용시에는 type 필수 넣기 -->
					<button type="button" onclick="bupdate()" class="updatebtn">수정하기</button>
				</div><!-- btn_section -->
				
				


			</div>

		</form>

	</div><!-- webbox -->

	<!-- 썸머노트 API js -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	
	<!-- 사용자정의 js -->
	<script type="text/javascript" src="/blog/js/board/tupdate.js"></script>


</body>
</html>