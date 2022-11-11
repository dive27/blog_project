package model.dto;

public class imgBoardDto {
	
	private int imgb_no; 
	private String imgb_title;
	private String imgb_content;
	private String imgb_file ;
	private String imbb_date ;
	private int  imbb_view;
	private int cno;
	private int cy_num;
	
    private int mno;  // 필요시 삭제 가능
    
	private String mid; //게시물 출력용?
	
	public imgBoardDto() {}
	
	
	public imgBoardDto(int imgb_no, String imgb_title, String imgb_content, String imgb_file, String imbb_date, int imbb_view) {
		this.imgb_no = imgb_no;
		this.imgb_title = imgb_title;
		this.imgb_content = imgb_content;
		this.imgb_file = imgb_file;
		this.imbb_date = imbb_date;
		this.imbb_view = imbb_view;
		
	}
	
	
	
	
	
	public imgBoardDto(int imgb_no, String imgb_title, String imgb_content, String imgb_file, String imbb_date,
			int imbb_view, int cno, int cy_num ) {
	
		this.imgb_no = imgb_no;
		this.imgb_title = imgb_title;
		this.imgb_content = imgb_content;
		this.imgb_file = imgb_file;
		this.imbb_date = imbb_date;
		this.imbb_view = imbb_view;
		this.cno = cno;
		this.cy_num = cy_num;
	}

	
	

	public imgBoardDto(int imgb_no, String imgb_title, String imgb_content, String imgb_file, String imbb_date,
			int imbb_view, int cno, int cy_num, int mno, String mid) {
	
		this.imgb_no = imgb_no;
		this.imgb_title = imgb_title;
		this.imgb_content = imgb_content;
		this.imgb_file = imgb_file;
		this.imbb_date = imbb_date;
		this.imbb_view = imbb_view;
		this.cno = cno;
		this.cy_num = cy_num;
		this.mno = mno;
		this.mid = mid;
	}


	public int getImgb_no() {
		return imgb_no;
	}


	public void setImgb_no(int imgb_no) {
		this.imgb_no = imgb_no;
	}


	public String getImgb_title() {
		return imgb_title;
	}


	public void setImgb_title(String imgb_title) {
		this.imgb_title = imgb_title;
	}


	public String getImgb_content() {
		return imgb_content;
	}


	public void setImgb_content(String imgb_content) {
		this.imgb_content = imgb_content;
	}


	public String getImgb_file() {
		return imgb_file;
	}


	public void setImgb_file(String imgb_file) {
		this.imgb_file = imgb_file;
	}


	public String getImbb_date() {
		return imbb_date;
	}


	public void setImbb_date(String imbb_date) {
		this.imbb_date = imbb_date;
	}


	public int getImbb_view() {
		return imbb_view;
	}


	public void setImbb_view(int imbb_view) {
		this.imbb_view = imbb_view;
	}


	public int getCno() {
		return cno;
	}


	public void setCno(int cno) {
		this.cno = cno;
	}


	public int getCy_num() {
		return cy_num;
	}


	public void setCy_num(int cy_num) {
		this.cy_num = cy_num;
	}


	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	@Override
	public String toString() {
		return "imgBoardDto [imgb_no=" + imgb_no + ", imgb_title=" + imgb_title + ", imgb_content=" + imgb_content
				+ ", imgb_file=" + imgb_file + ", imbb_date=" + imbb_date + ", imbb_view=" + imbb_view + ", cno=" + cno
				+ ", cy_num=" + cy_num + ", mno=" + mno + ", mid=" + mid + "]";
	}




	
	
	
	
}
