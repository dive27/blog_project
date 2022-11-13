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

import model.dao.TBoardDao;
import model.dto.TBaordDto;

/**
 * Servlet implementation class tlistall
 */
@WebServlet("/board/tlistall")
public class tlistall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tlistall() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int blogno = (Integer)request.getSession().getAttribute("blogno");
		ArrayList< TBaordDto > list = TBoardDao.getInstance().gettlistall(blogno);
		
		// ** arraylist ---> jsonarray 변환[ js에서 쓸려고 ]
		JSONArray array = new JSONArray();
		for( int i = 0  ; i<list.size() ; i++ ) {
			JSONObject object = new JSONObject();
			object.put("bno", list.get(i).getBno() );
			object.put("btitle", list.get(i).getBtitle() );
			object.put("bcontent", list.get(i).getBcontent() );
			object.put("bfile", list.get(i).getBfile() );
			object.put("bdate", list.get(i).getBdate() );
			object.put("bview", list.get(i).getBview() );
			object.put("cno", list.get(i).getCno() );
			object.put("mno", list.get(i).getMno() );
			object.put("mid", list.get(i).getMid() );
			array.add(object);
		}		
		
		// 3. 응답o
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().print( array );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
