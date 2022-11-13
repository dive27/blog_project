package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.ImgBoardDao;
import model.dto.imgBoardDto;




@WebServlet("/board/bimgOutPut")
public class bimgOutPut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public bimgOutPut() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 요청
		 request.setCharacterEncoding("UTF-8");
		 
		 int blogno = (Integer)request.getSession().getAttribute("blogno");
		
		// 1. 전체 게시물수 
		
		 int listsize = Integer.parseInt(request.getParameter("listsize"));
		 
		 System.out.println( "게시물수 : " + listsize);
		 
		int totalsize = ImgBoardDao.getInstance().imggettotalsize(  blogno );
		
		 System.out.println( "전체 게시물수 : " + totalsize);
		
		// 2. *전체 페이지수 계산
		int totalpage = 0;
		if( totalsize % listsize == 0 ) totalpage = totalsize / listsize;	// 나머지가 없으면
		else totalpage = totalsize / listsize + 1;	// 나머지가 존재하면 나머지를 표시할 페이지+1
		
		
		// 3. 현재 페이지 번호  a
		int page = Integer.parseInt( request.getParameter("page") );
		
		
		
		// 3. 페이지별 시작 게시물 행번호   [ 이거는 한번 더봐야할 듯.]
		int startrow = (page-1)*listsize;
			// 1페이지 -> 1-1 * 9 => 0 // 2페이지 -> 2-1 * 9 => 18 // 3페이지 -> 3-1 * 9 => 6
		
		// 3. 화면에 표시할 최대 버튼수 
		int btnsize = 5;	// 버튼 5개씩 표시 [ 몫 : 현재페이지가 최대버튼수 커지면 ]
		int startbtn =  ( (page-1) / btnsize ) * btnsize  + 1 ;	 // 버튼 시작번호 
		int endbtn = startbtn + (btnsize-1); 	// 버튼 끝번호 
			// 만약에 endbtn 마지막 페이지보다 크면 마지막버튼 번호는 마지막페이지 번호 
			if( endbtn > totalpage ) endbtn = totalpage;

		
	
		
		
		//2 DAO 처리. 
			
		JSONObject output = new JSONObject();// 페이징 처리 ?	
			
		  ArrayList< imgBoardDto > list =  ImgBoardDao.getInstance().getImglist ( blogno );

		  JSONArray array = new JSONArray();
		  
		  for ( int i = 0 ; i<list.size(); i++) {   //length vs size 사용하는 기준?     //objec 에 값  넣을대 출력하고자 하는거만 넣으면 되는건가?
			  JSONObject object = new JSONObject();
			  
			  object.put("imgb_no", list.get(i).getImgb_no());
			  object.put("imgb_title", list.get(i).getImgb_title());
			  object.put("imgb_file", list.get(i).getImgb_file());
			  object.put("imbb_view", list.get(i).getImbb_view());
			  array.add(object);
		  }
		  
		  
		  
		  output.put("totalpage", totalpage );	// 1. 전체 페이지수 
		  output.put("data", array);				// 2. 게시물 리스트 
		  output.put("startbtn", startbtn );	// 3. 버튼의 시작번호 
		  output.put("endbtn", endbtn );		// 4. 버튼의 끝번호 
		  output.put("totalsize", totalsize );	// 5. 전체 게시물 수 
		  
		  
		  
		  
		  response.setCharacterEncoding("UTF-8"); 
		  response.getWriter().print( output );
		  System.out.println( array );
	}

	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
