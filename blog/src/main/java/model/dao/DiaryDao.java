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
	
	public boolean dwrite( String content , int emono ) {									// 다이어리 작성 메소드
		String sql = "insert into diary ( di_content , emo_no ) values( ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, emono );
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("다이어리 작성 메소드 오류" + e);}
		return false;
	}	
	
	public ArrayList<DiaryDto> getdiary ( String date ) {									// 선택한 날짜 일기 가져오기 메소드
		String sql = "select * from diary where di_date =?";
			ArrayList<DiaryDto> list = new ArrayList<>();
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, date);
				rs = ps.executeQuery();
				if( rs.next() ) {
					DiaryDto dto = new DiaryDto(
							rs.getInt(1), rs.getString(2), 
							rs.getString(3), rs.getInt(4));
					list.add(dto);
					System.out.println("다오 들어왔어요");
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
	
	public int getemotionno() {																// 감정 번호 가져오기 메소드 - 아직 사용 안하고 있음
		String sql = "select emo_no from emotion";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next() ) {
				int emo_no = rs.getInt(1);
				return emo_no;
			}
		} catch (Exception e) {System.out.println( e + "감정 번호 가져오기 메소드 오류" );}
		return -1;
	}
	
	public boolean ifalreadywr( String today ) {											// 오늘 작성한 일기가 있는지 확인하는 메소드
		String sql = "select * from diary where di_date = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, today);
			if( rs.next() ) {
				return true;
			}
		} catch (Exception e) {System.out.println(e+"오늘 작성한 일기 있는지 확인하는 메소드 오류");}
		return false;
	}
	
	public boolean update_today_di( String content , String date , int emo_no ) {  // 오늘 일기 수정 메소드
		String sql = "update diary set di_content = ? , emo_no = ? where di_date = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setString(2, date);
			ps.setInt(3, emo_no);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e+"오늘 일기 수정 메소드 오류");}
		return false;
	}
}
