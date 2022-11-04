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
		int emono = Integer.parseInt(request.getParameter("emono")); // 만들어둔 다오 여기서 써야하나?
		System.out.println(emono);
		System.out.println(content);
		
		boolean result = DiaryDao.getInstance().dwrite(content, emono);
		
		System.out.println(result);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date = request.getParameter("date");
		System.out.println("date : " + date);
		
		ArrayList<DiaryDto> list = DiaryDao.getInstance().getdiary(date);

		// 리스트가 존재하지 않을때 일기가 없을떄  아예 'null'을 ajax로 보냄
		if( list == null ) { response.getWriter().print("null"); return; }
		
		JSONArray array = new JSONArray();
		for( DiaryDto dto : list ) {
			JSONObject object = new JSONObject();
			object.put("di_no", dto.getDi_no());
			object.put("di_date", dto.getDi_date());
			object.put("di_content", dto.getDi_content());
			object.put("em_no", dto.getEmo_no());
			array.add(object);
		}
		
		System.out.println(array);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
	}

	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String today = request.getParameter("to_day");
		
		System.out.println(today);
		
		boolean result = DiaryDao.getInstance().ifalreadywr(today);
		
		response.getWriter().print(result);
	}
}
