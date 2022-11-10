<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

   <link href="/blog/css/board/list.css" rel="stylesheet">
</head>
<body>
    
    
   <div class ="gallry_box">
  
    번호 : <div class="imno"> </div> <br>
    제목 : <div class="title"> </div> <br>
    첨부한이미지 : <div class="b_img"></div> <br>
    내용 : <div class="b_content"> </div>
    
   

    <div class="btnbox">	
	   <button type="button" onclick="pagechange('/blog/gallery/plist.jsp')">목록보기</button>
	</div>
    
   </div> 
   
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/blog/js/gallery/listdetail.js" type="text/javascript"></script>
    
</body>
</html>