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

@WebServlet("/member/inforlist")
public class inforlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public inforlist() { super();}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//MemberDao 10. 모든회원 호출
		ArrayList<MemberDto> list =  MemberDao.getInstance().getinforlist();
		
		//자바스크립트는 DTO를 절~~대 알 수가 없기 때문에 DTO를 JSON으로 바꿔줘야 한다
		JSONArray array = new JSONArray();	// 1. JSONObject를 여러개 담을 수 있는 JOSN리스트 선언
		for(MemberDto dto : list){
			JSONObject object =  new JSONObject(); // 2. JSONObject 생성
													// 3. JSONObject 에 엔트리(정보) 담기
			object.put("cy_num", dto.getCy_num());
		  	object.put("cy_id", dto.getCy_id());
		  	object.put("cy_name", dto.getCy_name());
		  	object.put("cy_phone",dto.getCy_phone());
			object.put("cy_email", dto.getCy_email());
			object.put("cy_nickname", dto.getCy_nickname());
			object.put("cy_signuptime", dto.getCy_signuptime());
			object.put("cy_cash", dto.getCy_cash());			
			array.add(dto); //4. JSONObject 객체를 리스트에 담는다			
		}		
			//System.out.println("inforlist.java array 확인 : " + array);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
