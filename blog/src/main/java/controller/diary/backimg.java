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
 * Servlet implementation class backimg
 */
@WebServlet("/backimg")
public class backimg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public backimg() {
        super();

    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int result = DiaryDao.getInstance().backimglist();
		
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int cy_num = MemberDao.getInstance().getcy_id( 
	            (String)request.getSession().getAttribute("cy_id") );	
		
		boolean result = DiaryDao.getInstance().alreadytable(cy_num);
		
		response.getWriter().print(result);
	}

}
