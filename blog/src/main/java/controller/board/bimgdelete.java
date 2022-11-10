package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ImgBoardDao;
import model.dto.imgBoardDto;



@WebServlet("/board/bimgdelete")
public class bimgdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
    public bimgdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//요청
		  int imgb_no = Integer.parseInt(request.getParameter("imgb_no"));
		  System.out.println("bimgdelete.java imgb_no 확인" + imgb_no);
		  
		  imgBoardDto dto = ImgBoardDao.getInstance().getboard( imgb_no);
		  
		//DAO처리
		   boolean result = ImgBoardDao.getInstance().imgdelete( imgb_no);
		   if( result ) {
			   String deletepath = request.getSession().getServletContext().getRealPath("/upload/" + dto.getImgb_file());
			   File file = new File( deletepath);
			   if( file.exists()) file.delete();
			   
		   }
		
		//
		    response.getWriter().print(result);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
