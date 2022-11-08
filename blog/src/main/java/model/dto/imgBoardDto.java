package model.dto;

public class imgBoardDto {
	
	private int imgb_no; 
	private String imgb_title;
	private String imgb_content;
	private String imgb_file ;
	private String imbb_date ;
	private int  imbb_view;
	
	public imgBoardDto() {}


	public imgBoardDto(int imgb_no, String imgb_title, String imgb_content, String imgb_file, String imbb_date,
			int imbb_view) {
		super();
		this.imgb_no = imgb_no;
		this.imgb_title = imgb_title;
		this.imgb_content = imgb_content;
		this.imgb_file = imgb_file;
		this.imbb_date = imbb_date;
		this.imbb_view = imbb_view;
	}



	public imgBoardDto(int imgb_no, String imgb_title, String imgb_file, int intimbb_view){
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "imgBoardDto [imgb_no=" + imgb_no + ", imgb_title=" + imgb_title + ", imgb_content=" + imgb_content
				+ ", imgb_file=" + imgb_file + ", imbb_date=" + imbb_date + ", imbb_view=" + imbb_view + "]";
	}

	
	
}
