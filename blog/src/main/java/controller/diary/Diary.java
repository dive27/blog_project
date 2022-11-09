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
		System.out.println("일기작성 감정번호"+emono);
		System.out.println("일기작성 일기내용"+content);
		System.out.println("일기작성자 번호 : "+cy_num);
		
		boolean result = DiaryDao.getInstance().dwrite(content, emono, cy_num);
		
		System.out.println("일기작성 반환값"+result);
		
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
			array.add(object);
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
	}

	
	@Override	// 오늘 일기 수정 관련
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("오늘일기 유무 풋 들어옴");
		
			String today = (String.valueOf(request.getParameter("today")));
			int cy_num = MemberDao.getInstance().getcy_id( 
		            (String)request.getSession().getAttribute("cy_id") );
		
			System.out.println("오늘일기 유무 풋 오늘 날짜 : "+today);
		
			
			boolean result = DiaryDao.getInstance().ifalreadywr(today , cy_num);
			System.out.println("오늘일기 유무 풋 반환값"+result);
			
			response.getWriter().print(result);		// 널값만 전달돼서 테스트 위해 임의로 이렇게 써둠
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("일기수정 딜리트에 들어왔어요");
		String content = request.getParameter("content");
		String today = request.getParameter("today");
		int cy_num = MemberDao.getInstance().getcy_id( 
	            (String)request.getSession().getAttribute("cy_id") );
		int emono = Integer.parseInt(request.getParameter("emono")) ;
		
		System.out.println("일기수정 - 일기 : " + content);
		System.out.println("일기수정 - 오늘 날짜 : " + today);
		System.out.println("일기수정 - 감정" + emono);
		
		boolean result = DiaryDao.getInstance().update_today_di(content, today, emono , cy_num);
		System.out.println("result : " + result);
		
		response.getWriter().print(result);
	}
}
