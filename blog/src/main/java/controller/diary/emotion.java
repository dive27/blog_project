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

import model.dao.DiaryDao;
import model.dao.MemberDao;
import model.dto.DiaryDto;
import model.dto.EmotionDto;

/**
 * Servlet implementation class emotion
 */
@WebServlet("/emotion")
public class emotion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public emotion() {
        super();
        
    }


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cy_num = MemberDao.getInstance().getcy_id( 
	            (String)request.getSession().getAttribute("cy_id") );	
		ArrayList<EmotionDto> list = DiaryDao.getInstance().getemotion( cy_num );
		
		JSONArray array = new JSONArray();
		for( EmotionDto dto : list ) {
			JSONObject object = new JSONObject();
			object.put("emo_no", dto.getEmo_no());
			object.put("emotion", dto.getEmotion());
			object.put("emo_img", dto.getEmo_img());
			array.add(object);
		}
				
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int emono = Integer.parseInt(request.getParameter("emono"));
		int cy_num = MemberDao.getInstance().getcy_id( 
	            (String)request.getSession().getAttribute("cy_id") );
		
		String emotion = request.getParameter("emotion");
		
		
		boolean result = DiaryDao.getInstance().updateemtion(emotion, emono , cy_num);
		
		
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
