package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.ImgBoardDao;
import model.dao.MemberDao;
import model.dto.imgBoardDto;







@WebServlet("/board/bimgdetail")
public class bimgdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bimgdetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청
	     int imgb_no = (Integer)request.getSession().getAttribute("imgb_no");
	     System.out.println("bimgdetaill.java img_no"+ imgb_no + "\n" );
	     
	//2.DAO 처리
	
	     imgBoardDto dto = new ImgBoardDao().getboard( imgb_no );
	     System.out.println("bimgdetail dto확인" + dto);
	
	//3.  DTO -- JSON 형변환..
	    JSONObject object = new JSONObject();
		object.put("imgb_no", dto.getImgb_no());
		object.put("imgb_title", dto.getImgb_title());
		object.put("imgb_content", dto.getImgb_content());
		object.put("imgb_file", dto.getImgb_file() );
		object.put("imbb_date", dto.getImbb_date() );
		object.put("imbb_view", dto.getImbb_view() );
		object.put("cno", dto.getCno() );
		object.put("cy_num", dto.getCy_num() ); // 작성ㅇ자의 회원번호
	

		     // 1. 로그인한 세션 정보 호출
		     int cy_num = MemberDao.getInstance().getcy_id( (String)request.getSession().getAttribute("cy_id") ); // 현재 로그인된 회원번호

		     //로그인한 세션과 현재 게시물의 작성자와 일치하면
		     if( cy_num != 0  && cy_num ==  dto.getCy_num() ) {
		    	  object.put ("btnaction", true );
		    	  System.out.println("btnaction 확인"+ "btnaction");		    	  
		     }
	
		// 4. 응답 
		response.setCharacterEncoding("utf-8");
		response.getWriter().print( object );
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
