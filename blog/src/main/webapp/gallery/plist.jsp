<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<link href="/blog/css/board/list.css" rel="stylesheet">
</head>
<body>


      <div class ="gallry_box">
        	
      
           <div id ="box1">   <!-- 게시물 전체추력 -->
	       </div>
		
	      <div class="pagebox">	<!-- 페이징처리 -->
		
		  </div>
	   
	   <div>

		<button type="button"  id="btnbox1" onclick="pagechange('/blog/gallery/picturwrite.jsp')">이미지등록</button>
		</div>	
	
     </div>
		
	   <script src="http://code.jquery.com/jquery-latest.min.js"></script>
       <script src="/blog/js/gallery/blist.js"  type="text/javascript"> </script>
  
</body>
</html>

