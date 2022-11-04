<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- 썸머노트 API -->
	<!-- include libraries(jQuery, bootstrap) -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

<title> 글쓰기 </title>
</head>
<body>

	<div class="webbox">
		<h3> 글쓰기 </h3>
		
		
		<form>
			제목 : <input type="text" name="btitle"> <br>
			
			<!-- 썸머노트  -->
			<textarea id="summernote" name="bcontent"></textarea>
			첨부파일 : <input type="file" name ="bfile"> <br>
			<!-- form 태그 안에서 button 사용시에는 type 필수 넣기 -->
			<button type="button" onclick="bwrite()"> 글 등록하기 </button>
		</form>
	</div>
	
	
	<!-- 썸머노트 API js -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	
	<!-- 사용자정의 js -->
	<script src="/blog/js/board/twrite.js" type="text/javascript"></script>


</body>
</html>