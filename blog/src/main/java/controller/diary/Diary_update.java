package controller.diary;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DiaryDao;
import model.dao.MemberDao;

/**
 * Servlet implementation class Diary_update
 */
@WebServlet("/Diary_update")
public class Diary_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Diary_update() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String today = (String.valueOf(request.getParameter("today")));
		int cy_num = MemberDao.getInstance().getcy_id( 
	            (String)request.getSession().getAttribute("cy_id") );
		
		boolean result = DiaryDao.getInstance().ifalreadywr(today , cy_num );
		
		response.getWriter().print(result);		// 널값만 전달돼서 테스트 위해 임의로 이렇게 써둠
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String content = request.getParameter("content");
		String today = request.getParameter("today");
		int cy_num = MemberDao.getInstance().getcy_id( 
	            (String)request.getSession().getAttribute("cy_id") );
		int emono = Integer.parseInt(request.getParameter("emono")) ;
		int backno = Integer.parseInt(request.getParameter("backno"));
			
		boolean result = DiaryDao.getInstance().update_today_di(content, today, emono , cy_num , backno );
		
		response.getWriter().print(result);
	}

}
