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
		int cy_num = Integer.parseInt(request.getParameter("cy_num"));
		System.out.println(emono);
		System.out.println(content);
		
		boolean result = DiaryDao.getInstance().dwrite(content, emono, cy_num);
		
		System.out.println(result);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date = request.getParameter("date");
		int cy_num = Integer.parseInt(request.getParameter("cy_num")) ;
		
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
			array.add(object);
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
	}

	
	@Override	// 오늘 일기 수정 관련
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("풋");
		
			String today = (String.valueOf(request.getParameter("today")));
			int cy_num = Integer.parseInt(request.getParameter("cy_num")) ;
		
			System.out.println("풋 오늘 날짜 : "+today);
		
			
			boolean result = DiaryDao.getInstance().ifalreadywr(today , cy_num);
			System.out.println(result);
			
			response.getWriter().print(result);	
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("일기수정 딜리트에 들어왔어요");
		String content = request.getParameter("content");
		String today = request.getParameter("today");
		int cy_num = Integer.parseInt(request.getParameter("cy_num")) ;
		int emono = Integer.parseInt(request.getParameter("emono")) ;
		
		System.out.println("딜리트 - 일기 : " + content);
		System.out.println("딜리트 - 오늘 날짜 : "+today);
		System.out.println("감정"+emono);
		
		boolean result = DiaryDao.getInstance().update_today_di(content, today, emono , cy_num);
		System.out.println("result : " + result);
		
		//response.getWriter().print(result);
	}
}
