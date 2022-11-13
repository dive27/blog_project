package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class followadd
 */
@WebServlet("/member/followadd")
public class followadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public followadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 사람 아이디의 회원번호 
		int cy_num_from =  MemberDao.getInstance().getcy_id( (String)request.getSession().getAttribute("cy_id") );
		
		// dao 처리 
		ArrayList<MemberDto> list = MemberDao.getInstance().followget(cy_num_from);
		// list -> jsonarray 
		JSONArray array = new JSONArray();
		for( MemberDto dto  : list ) {
			JSONObject object = new JSONObject();
			object.put("cy_num", dto.getCy_num());
			object.put("cy_id", dto.getCy_id());
			object.put("cy_name", dto.getCy_name());
			object.put("cy_phone", dto.getCy_phone());
			object.put("cy_email", dto.getCy_email());
			object.put("cy_nickname", dto.getCy_nickname());
			object.put("cy_signuptime", dto.getCy_signuptime());
			array.add(object);
		}
		// 응답 처리 
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // 한글 인코딩 
		String cy_id = request.getParameter("cy_id");	// 받는 사람 아이디  
		String cy_follow_message = request.getParameter("cy_follow_message"); // 3. 신청 메시지 
		
		// 현재 로그인 사람의 아이디로 회원번호 찾기 // 1. 신청한 사람의 아이디로 회원번호 찾기 
		int cy_num_from =  MemberDao.getInstance().getcy_id( (String)request.getSession().getAttribute("cy_id") );
		// 입력받은 아이디로 회원번호 찾기 // 2. 받는 사람의 아이디로 회원번호 찾기 
		int cy_num_to = MemberDao.getInstance().getcy_id( cy_id );
	
		// dao 처리 
		boolean result = MemberDao.getInstance().followadd( cy_num_from , cy_num_to , cy_follow_message );
		// 결과 응답 
		response.getWriter().print(result);
		
		
		
	}
}






















