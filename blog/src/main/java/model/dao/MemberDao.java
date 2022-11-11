package model.dao;

import java.util.ArrayList;

import model.dto.MemberDto;
public class MemberDao extends Dao {
	//싱글톤선언
	private static MemberDao mdao  = new MemberDao();
	//호출이 가능한 아이를 만듬
	public static MemberDao getInstance() {return mdao;}
	
	//1. 회원가입 (signup.jsp)
	
	public boolean signup(MemberDto dto) {
		String sql = "insert into Cywold_signup(cy_id,cy_password,cy_name,cy_phone,cy_email)values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getCy_id());
			ps.setString(2, dto.getCy_password());
			ps.setString(3, dto.getCy_name());
			ps.setString(4, dto.getCy_phone());
			ps.setString(5, dto.getCy_email());
			ps.executeUpdate();
			return true;			
		} catch (Exception e) { System.out.println("MemberDao 1.signup오류" + e);}
		return false;
	}//signup end
		
	//2. 아이디 중복체크 (idcheck.jsp)
	public boolean idcheck(String cy_id) {
		String sql = "select * from Cywold_signup where cy_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cy_id);
			rs = ps.executeQuery();
			if(rs.next()) //계속 사용중인 아이디라고 떠서 여기저기확인하다가 rs.next에 ;하나 지웠다고 된다고?이게 된다고????
			return true;
		} catch (Exception e) { System.out.println("MemberDao 2. 아이디 중복체크 오류" + e);}
		return false;
	}
	
	//3. 이메일 중복체크
	public boolean emailcheck(String cy_email) {
		String sql = "select * from Cywold_signup where cy_email=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cy_email);
			rs = ps.executeQuery();
			if(rs.next()) 
			return true;
		} catch (Exception e) { System.out.println("MemberDao 3. 아이디 중복체크 오류" + e);}
		return false;
	}
	
	//4.로그인 //아이디가 틀리거나 비밀번호가 틀리거나 로그인에 성공하거나 둘다 틀리거나 회원이 아니거나
	public int login(String cy_id, String cy_password ) { //아이디가 먼저 있는지 없는지 확인
		//System.out.println("  MemberDao  4.로그인 id  : "+  cy_id);
		
		String sql = "select * from Cywold_signup where cy_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1 , cy_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				sql = "select * from Cywold_signup where cy_id = ? and cy_password = ? ";
				ps = con.prepareStatement(sql);
				ps.setString(1, cy_id);
				ps.setString(2, cy_password);
				rs = ps.executeQuery();
				if(rs.next()) {return 1;} //로그인성공
				return 2; // 비밀번호 틀림
			}
		} catch (Exception e) {System.out.println("MemberDao 4.로그인 메소드 오류" + e); return 3;} // db오류
			return 0; // 아이디가 없다. 
	}
	
	//5. 아이디찾기 
	public String findid(String cy_name ,String cy_email) {
		String sql = "select * from Cywold_signup where cy_name = ? and cy_email = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cy_name);
			ps.setString(2, cy_email);
			rs = ps.executeQuery(); 
			if(rs.next()) return rs.getString(2);//만일 동일한 정보가 있으면 찾은 레코드의 아이디를 반환한다. 필드순서임!!			
		} catch (Exception e) {System.out.println("MemberDao 5. 아이디 찾기 오류" +e);}
		return null;
	}
	
	
	//6. 비밀번호 찾기 난수를 발생시켜 임시비밀	번호를 발급 여부 판단
	public boolean findpassword(String cy_id, String cy_email) {
		String sql = "select * from Cywold_signup where cy_id = ? and cy_email = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cy_id);
			ps.setString(2, cy_email);
			rs = ps.executeQuery();
			if(rs.next()) return true;
		} catch (Exception e) {System.out.println("MemberDao 6.임시비빌번호 발급 오류" + e);}
		return false;		
	}
	
	//7. 임시비빌번호 업데이트
	public boolean passwordchange(String cy_id, String randstr) {
		String sql = "update Cywold_signup set cy_password = ? where cy_id = ?";
		try {
			ps = con.prepareStatement(sql);   
			ps.setString(1, randstr);
			ps.setString(2, cy_id);
			ps.executeUpdate(); 
			return true;
		} catch (Exception e) {System.out.println("MemberDao 7. 임시비밀번호 업데이트 오류" + e);}
		return false;
	}
	
	
	//8. 회원 아이디를 가지고 회원번호를 찾는 메소드
	public int getcy_id(String cy_id ) {
		String sql = "select cy_num from Cywold_signup where cy_id = ? ";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, cy_id);
			rs = ps.executeQuery();
			if(rs.next()) return rs.getInt(1);
		} catch (Exception e) {System.out.println("MemberDao 8.회원아이디를 가지고 회원번호를 찾는 메소드" + e);}
		return 0;
	}
	
	
	
	// 11/10 예은 추가 
	//8-2 회원 이름을 가지고 회원 이름을 찾는 메소드	
	
	public String getcy_name(String cy_name) {
		String sql = "select cy_name from Cywold_signup where cy_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cy_name);
			rs = ps.executeQuery();			
			if(rs.next()); return rs.getString(1);			
		} catch (Exception e) {System.out.println("MemberDao 8-1 회원 이름을 가지고 회원 이름을 찾는 메소드 오류" + e);}
		
		return null;
	}
	
	
	
	// 9. 내 회원정보 호출하기
	public MemberDto getmyinfor(String cy_id ) {
		MemberDto dto = null;
		String sql = "select * from Cywold_signup where cy_id = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cy_id);
			rs = ps.executeQuery();
			if(rs.next()) {				
				dto = new MemberDto(
						rs.getInt(1), 
						rs.getString(2), 
						null,
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8), 					
						rs.getInt(9));	
				return dto;
			}
				//System.out.println("MemberDao dto 확인 : " + dto+ "\n");
		} catch (Exception e) {System.out.println("MemberDao 9.회원정보 가져오기 오류" + e);}
		return dto;
	}
	
	
	// 10. 모든회원 호출
	public ArrayList<MemberDto> getinforlist(){
		ArrayList<MemberDto> list = new ArrayList<>(); // 1. 리스트선언		
		String sql = "select * from Cywold_signup";	 // 2.SQL 작성
		try {
			ps = con.prepareStatement(sql);  // 3. SQL 연결
			rs = ps.executeQuery();			// 4. SQL 실행
			while(rs.next()) {				// 5. SQL 결화 레코드 반복호출
			MemberDto dto = new MemberDto( // 6. 레코드 --> DTO 객체
				rs.getInt(1), rs.getString(2), 
				null, rs.getString(4), 
				rs.getString(5), rs.getString(6), 
				rs.getString(7), rs.getString(8), rs.getInt(9));
				list.add(dto);				// 7.  DTO --> 리스트담기
			}
			return list;					// 8. 결과반환
		} catch (Exception e) {System.out.println("MemberDao 10. 모든 회원 호출하기 오류 " + e);}
		return list;
	}
	
	
	// 11. 회원 탈퇴하기
	public boolean deleteinfor(String cy_id , String  cy_password) {
		String sql = "delete from Cywold_signup where cy_id = ? and cy_password = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cy_id);
			ps.setString(2, cy_password);
			
			int count = ps.executeUpdate(); // 삭제레코드 수 반환
			if( count == 1 ) {return true;} //만약에 삭제할 레코드개수가 1이면 
			
			//System.out.println("MemberDao 11 count 확인 : "+count);	
			
		} catch (Exception e) {System.out.println("MemberDao 11. 회원탈퇴하기 오류" + e);}
		return false;
		
	}
	
	// 12. 회원정보 수정하기
	public boolean updateinfor(String cy_id,String cy_name, String cy_phone, String cy_email ) {
		String sql = "update Cywold_signup set  cy_name = ? , cy_phone= ? , cy_email = ? where cy_id = ? ";
		//update 테이블명 set 필드명 ? where 식별자
		try {
			ps = con.prepareStatement(sql);			
			ps.setString(1, cy_name);
			ps.setString(2, cy_phone);
			ps.setString(3, cy_email);	
			ps.setString(4, cy_id);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("MemberDao 12 회원정보 수정하기 오류" + e); }
		return false;
	}
	
	// 13. 회원이미지 등록하기
	public boolean imgadd(String cy_profile_img, int cy_num) {
		String sql = "null";
		// 1.먼저 이미지 테이블에 해당 회원번호가 존재하는지 select
		sql = "select * from Cywold_signup_pforile_img where cy_num=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cy_num);
			rs = ps.executeQuery();
			if (rs.next()) {
				// 1. 만약에 존재하면 update
				sql = "update Cywold_signup_pforile_img set cy_profile_img= ? , cy_num= ? ";
				ps = con.prepareStatement(sql);
				ps.setString(1, cy_profile_img);
				ps.setInt(2, cy_num);
				ps.executeUpdate();
				return true;
			} else {
				// 2. 존재하지 않으면 insert
				sql = "insert into Cywold_signup_pforile_img( cy_profile_img , cy_num ) values(?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, cy_profile_img);
				ps.setInt(2, cy_num);
				ps.executeUpdate();
				return true;
			}
		} catch (Exception e) {
			System.out.println("MemberDao 13 회원이미지 등록하기 오류" + e);
		}
		return false;
	}
	// 14 
	public String getimg( int cy_num )  {
		String sql = "select cy_profile_img from Cywold_signup_pforile_img where cy_num = "+cy_num;
		try {
			ps = con.prepareStatement(sql);  // 3. SQL 연결
			rs = ps.executeQuery();			// 4. SQL 실행
			if( rs.next() ) { return rs.getString(1); }
		} catch (Exception e) {System.out.println("MemberDao 14. 모든 회원 호출하기 오류 " + e);}
		return null;
	}
	
}//MemberDao end
