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

import model.dao.MemberDao;
import model.dao.TBoardDao;
import model.dto.TBaordDto;

/**
 * Servlet implementation class list
 */
@WebServlet("/board/tlist")
public class tlist extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8"); // 한글인코딩
		int blogno = (Integer)request.getSession().getAttribute("blogno");
		
		
		
		///// 검색처리 /////////////
		String key		= request.getParameter("key");			System.out.println( key );
		String keyword	= request.getParameter("keyword");		System.out.println( keyword );
		
		
		
		


		// 1. 페이지당 게시물수 
		int listsize = Integer.parseInt(request.getParameter("listsize"));
		
		// 2. 전체 게시물수 vs 검색된 게시물 수 
		int totalsize = TBoardDao.getInstance().tgettotalsize( key , keyword , blogno);
		
		// 3. *전체 페이지수 계산
		int totalpage = 0;
		if( totalsize % listsize == 0 ) totalpage = totalsize / listsize;	// 나머지가 없으면
		else totalpage = totalsize / listsize + 1;	// 나머지가 존재하면 나머지를 표시할 페이지+1
		
		// 3. 현재 페이지 번호  
		int page = Integer.parseInt( request.getParameter("page" )  );
		
		// 3. 페이지별 시작 게시물 행번호 
		int startrow = (page-1)*listsize;
			// 1페이지 -> 1-1 * 3 => 0 // 2페이지 -> 2-1 * 3 => 3 // 3페이지 -> 3-1 * 3 => 6
		
		// 3. 화면에 표시할 최대 버튼수 
		int btnsize = 5;	// 버튼 5개씩 표시 [ 몫 : 현재페이지가 최대버튼수 커지면 ]
		int startbtn =  ( (page-1) / btnsize ) * btnsize  + 1 ;	 // 버튼 시작번호 
		int endbtn = startbtn + (btnsize-1); 	// 버튼 끝번호 
			// 만약에 endbtn 마지막 페이지보다 크면 마지막버튼 번호는 마지막페이지 번호 
			if( endbtn > totalpage ) endbtn = totalpage;
		
		
		// * 페이징처리에 필요한 정보 담는 jsonobject 
		JSONObject boards = new JSONObject();
		// 2. 전체 게시물 호출 vs 검색된 게시물 호출 
		ArrayList<TBaordDto> list =  TBoardDao.getInstance().getlist( startrow , listsize , key , keyword ,  blogno);
			// ** arraylist ---> jsonarray 변환[ js에서 쓸려고 ]
			JSONArray array = new JSONArray();
			for( int i = 0  ; i<list.size() ; i++ ) {
				JSONObject object = new JSONObject();
				object.put("bno", list.get(i).getBno() );
				object.put("btitle", list.get(i).getBtitle() );
				object.put("bdate", list.get(i).getBdate() );
				object.put("bview", list.get(i).getBview() );
				object.put("mid", list.get(i).getMid() );
				array.add(object);
			}		
		// 4. 
		boards.put("totalpage", totalpage );	// 1. 전체 페이지수 
		boards.put("data", array);				// 2. 게시물 리스트 
		boards.put("startbtn", startbtn   );	// 3. 버튼의 시작번호 
		boards.put("endbtn", endbtn   );		// 4. 버튼의 끝번호 
		boards.put("totalsize", totalsize   );	// 5. 전체 게시물 수 
		
		// 3. 응답o
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().print( boards );
		
		
		
		
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tlist() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}