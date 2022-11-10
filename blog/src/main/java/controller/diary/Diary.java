package controller.diary;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.Dao;
import model.dao.DiaryDao;
import model.dao.MemberDao;
import model.dto.DiaryDto;

/**
 * Servlet implementation class Diary
 */
@WebServlet("/Diary")
public class Diary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Diary() {
        super();
     
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
		String content = request.getParameter("content");
		int emono = Integer.parseInt(request.getParameter("emono")); 
		int cy_num = MemberDao.getInstance().getcy_id( 
	            (String)request.getSession().getAttribute("cy_id") );
		
		boolean result = DiaryDao.getInstance().dwrite(content, emono, cy_num);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date = request.getParameter("date");
		int cy_num = MemberDao.getInstance().getcy_id( 
	            (String)request.getSession().getAttribute("cy_id") );
		
		ArrayList<DiaryDto> list = DiaryDao.getInstance().getdiary(date , cy_num);
		
		// 리스트가 존재하지 않을때 일기가 없을떄  아예 'null'을 ajax로 보냄
		if( list == null ) { response.getWriter().print("null"); return; }
		
		JSONArray array = new JSONArray();
		for( DiaryDto dto : list ) {
			JSONObject object = new JSONObject();
			object.put("di_no", dto.getDi_no());
			object.put("di_date", dto.getDi_date());
			object.put("di_content", dto.getDi_content());
			object.put("em_no", dto.getEmo_no());
			object.put("cy_num", dto.getCy_num());
			object.put("backno", dto.getBack_img_no());
			array.add(object);
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
	}

}
