package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.ImgBoardDao;
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
	     
	     System.out.println( imgb_no );
	     
	//2.DAO 처리
	
	     imgBoardDto dto = new ImgBoardDao().getboard( imgb_no );

	
	//3.  DTO -- JSON 형변환..
	    JSONObject object = new JSONObject();
		object.put("imgb_no", dto.getImgb_no());
		object.put("imgb_title", dto.getImgb_title());
		object.put("imgb_content", dto.getImgb_content());
		object.put("imgb_file", dto.getImgb_file() );
		object.put("imbb_date", dto.getImbb_date() );
		object.put("imbb_view", dto.getImbb_view() );
	
	
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
