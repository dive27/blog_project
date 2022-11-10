package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.MemberDao;
import model.dto.MemberDto;



@WebServlet("/member/myinfor")
public class myinfor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public myinfor() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 1.세션에 로그인정보 호출
		String cy_id = (String)request.getSession().getAttribute("cy_id");
			//세션은 object이기 때문에 반드시 형변환을 해줘야 한다.
			System.out.println("myinfor.java cy_id 확인 : "+ cy_id);
		//int cy_num = Integer.parseInt(request.getParameter("cy_num"));
			
		//11/10 이름가져오기 추가 예은
		//String cy_name = (String)request.getSession().getAttribute("cy_name");
			//System.out.println("myinfor.java cy_name 확인 : " +  cy_name); //null?이라뇨?
		
		
		// 2. Dao에 있는 메소드를 작성하고 호출한다. 싱글톤으로 작성했기 때문에 getInstance()를 사용함
				
		  //MemberDao 9. 내 회원정보 호출하기
		  MemberDto dto = MemberDao.getInstance().getmyinfor(cy_id);
		  
		  	//System.out.println("myinfor.java dto 확인 : "+dto);
		  
		  //자바스크립트는 dto를 사용하지 못하기 때문에 알아들을 수 있도록 형식으로 변경을 해야한다. //대표적으로 JSON이 있다. 
		  //DTO -> JSON 반환 
		  JSONObject object = new JSONObject(); 
		  	object.put("cy_num", dto.getCy_num());
		  	object.put("cy_id", dto.getCy_id());
		  	object.put("cy_name", dto.getCy_name());
		  	object.put("cy_phone",dto.getCy_phone());
			object.put("cy_email", dto.getCy_email());
			object.put("cy_nickname", dto.getCy_nickname());
			object.put("cy_signuptime", dto.getCy_signuptime());
			object.put("cy_cash", dto.getCy_cash());
			
			//System.out.println("myinfor.java object 확인 : " + object + "\n");
		 
			
		
		  //3. 결과값을 보내기 위해 응답함 
		  response.setCharacterEncoding("UTF-8");
		  response.getWriter().print( object );
		  	//System.out.println("myinfor.java dto 확인 : " + object);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
	}

}
