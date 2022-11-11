package model.dto;

public class DiaryDto {

	private int di_no ;
	private String di_date ;
	private String di_content ;
	private int emo_no ;
	private int cy_num ;
	private int back_img_no ;
	
	public DiaryDto() {}

	public int getDi_no() {
		return di_no;
	}

	public void setDi_no(int di_no) {
		this.di_no = di_no;
	}

	public String getDi_date() {
		return di_date;
	}

	public void setDi_date(String di_date) {
		this.di_date = di_date;
	}

	public String getDi_content() {
		return di_content;
	}

	public void setDi_content(String di_content) {
		this.di_content = di_content;
	}

	public int getEmo_no() {
		return emo_no;
	}

	public void setEmo_no(int emo_no) {
		this.emo_no = emo_no;
	}

	public int getCy_num() {
		return cy_num;
	}

	public void setCy_num(int cy_num) {
		this.cy_num = cy_num;
	}

	public int getBack_img_no() {
		return back_img_no;
	}

	public void setBack_img_no(int back_img_no) {
		this.back_img_no = back_img_no;
	}

	public DiaryDto(int di_no, String di_date, String di_content, int emo_no, int cy_num, int back_img_no) {
		super();
		this.di_no = di_no;
		this.di_date = di_date;
		this.di_content = di_content;
		this.emo_no = emo_no;
		this.cy_num = cy_num;
		this.back_img_no = back_img_no;
	}

	@Override
	public String toString() {
		return "DiaryDto [di_no=" + di_no + ", di_date=" + di_date + ", di_content=" + di_content + ", emo_no=" + emo_no
				+ ", cy_num=" + cy_num + ", back_img_no=" + back_img_no + "]";
	}
	
	
}
