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
	     	// int imgb_no = (Integer)request.getSession().getAttribute("imgb_no");
		
		//2 DAO 처리. 
		   ArrayList< imgBoardDto > list =  ImgBoardDao.getInstance().getImglist( );
		
		  JSONArray array = new JSONArray();
		  
		  for ( int i = 0 ; i<list.size(); i++) {   //length vs size 사용하는 기준?     //objec 에 값  넣을대 출력하고자 하는거만 넣으면 되는건가?
			  JSONObject object = new JSONObject();
			  
			  object.put("imgb_no", list.get(i).getImgb_no());
			  object.put("imgb_title", list.get(i).getImgb_title());
			  object.put("imgb_file", list.get(i).getImgb_file());
			  object.put("imbb_view", list.get(i).getImbb_view());
			  array.add(object);
		  }
		 
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().print( array );
		 System.out.println( array );
	}

	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
