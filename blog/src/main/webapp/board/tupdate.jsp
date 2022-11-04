<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시글 수정 </title>
	
	<!-- 썸머노트 API css -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

</head>
<body>

	<!-- 성지혜 : 게시판 - 수정 페이지 -->
	
	<div class="webbox">
		<h3> 게시물 수정 </h3>
		
		<form>
			제목 : <input type="text" name="btitle" class="btitle"> <br>
			
			<!-- 썸머노트  -->
			<textarea id="summernote" name="bcontent" class="bcontent"></textarea>
			첨부파일 : <input type="file" name ="bfile" class="bfile"> <br>
			
			<!-- 기존 첨부파일 이름과 삭제버튼 표시 구역 -->
			<div class="oldbfilebox" id="oldbfilebox"></div>
			
			<!-- form 태그 안에서 button 사용시에는 type 필수 넣기 -->
			<button type="button" onclick="bupdate()"> 수정하기 </button>
		</form>
		
	</div>
	
	<!-- 썸머노트 API js -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	
	<!-- 사용자정의 js -->
	<script type="text/javascript" src="/blog/js/board/tupdate.js"></script>


</body>
</html>