package model.dao;

import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dto.DiaryDto;
import model.dto.EmotionDto;

public class DiaryDao extends Dao{

	private static DiaryDao ddao = new DiaryDao();
	public static DiaryDao getInstance() { return ddao; }
	
	public boolean dwrite( String content , int emono , int cy_num , int backno ) {									// 다이어리 작성 메소드
		String sql = "insert into diary ( di_content , emo_no , cy_num , back_img_no ) values( ? , ? , ? , ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, emono );
			ps.setInt(3, cy_num);
			ps.setInt(4, backno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("다이어리 작성 메소드 오류" + e);}
		return false;
	}	
	
	public ArrayList<DiaryDto> getdiary ( String date , int cy_num ) {									// 선택한 날짜 일기 가져오기 메소드
		String sql = "select * from diary where di_date =? and cy_num = ?";
			ArrayList<DiaryDto> list = new ArrayList<>();
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, date);
				ps.setInt(2, cy_num);
				rs = ps.executeQuery();
				if( rs.next() ) {
					DiaryDto dto = new DiaryDto(
							rs.getInt(1), rs.getString(2), 
							rs.getString(3), rs.getInt(4),
							rs.getInt(5), rs.getInt(6)
							);
					list.add(dto);
					return list;
					}
			} catch (Exception e) {System.out.println( e +"다이어리 출력 메소드 오류" );}
			return null;
		}
	
	public ArrayList<EmotionDto> getemotion() {												// 전체 감정 가져오기 테이블 출력용
		String sql = "select * from emotion";
		ArrayList<EmotionDto> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {						
				EmotionDto dto = new EmotionDto(
						rs.getInt(1), rs.getString(2), rs.getString(3)
						);
				list.add(dto);
			}
		} catch (Exception e) {System.out.println( e + "전체 감정 가져오기 메소드 오류");}
		return list;
	}
	
	public boolean updateemtion( String emotion , int emono ) { 							// 감정 설명 수정 메소드
		String sql = "update emotion set emotion = ? where emo_no = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 ,emotion );
			ps.setInt( 2, emono );
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e+"감정 설명 수정 메소드 오류");}
		return false;
	}
	
	public boolean ifalreadywr( String today , int cy_num ) {											// 오늘 작성한 일기가 있는지 확인하는 메소드
		String sql = "select * from diary where di_date = ? and cy_num =? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, today);
			ps.setInt(2, cy_num);
			rs = ps.executeQuery();
			if( rs.next() ) {
				return true;
			}
		} catch (Exception e) {System.out.println(e+"오늘 작성한 일기 있는지 확인하는 메소드 오류");}
		return false;
	}
	
	public boolean update_today_di( String content , String date , int emo_no , int cy_num , int backno) {  // 오늘 일기 수정 메소드
		String sql = "update diary set di_content = ? , emo_no = ? where di_date = ? and cy_num = ? and back_img_no = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, emo_no);
			ps.setString(3, date);
			ps.setInt(4, cy_num);
			ps.setInt(5, backno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e+"오늘 일기 수정 메소드 오류");}
		return false;
	}
	
	public int backimglist() { // 배경 이미지 개수 가져오는 메소드
		String sql = "select back_img_no from backimg order by back_img_no desc limit 1;";	// 유저 상관없이 다 동일하게 가지고 있음 / cy_num연결하면 디비 둥글게됨
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next() ) {
				int imgmaxno = rs.getInt(1);
				return imgmaxno;
			}
		} catch (Exception e) {System.out.println(e+"배경 이미지 개수 가져오는 매소드 오류");}
		return -1;
	}
	
	// 로그인 시 기본 감정테이블 부여
	public boolean youremotable( int cy_num ) {
		String sql = "insert into emotion values"
				+ "( null , '슬픈 날' , '하트1.gif' , ?),"
				+ "( null , '행복한 날' , '하트2.gif' , ?),"
				+ "( null , '화나는 날' , '하트3.gif' , ?),"
				+ "( null , '즐거운 날' , '하트4.gif' , ?),"
				+ "( null , '행복한 날' , '하트5.gif' , ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cy_num);
			ps.setInt(2, cy_num);
			ps.setInt(3, cy_num);
			ps.setInt(4, cy_num);
			ps.setInt(5, cy_num);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e+"기본 감정 테이블 부여 메소드 오류");}
		return false;
	}
}
