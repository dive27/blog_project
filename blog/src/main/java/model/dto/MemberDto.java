package model.dto;

public class MemberDto {

	private int cy_num; 
	private String cy_id; 
	private String cy_password;
	private String cy_name;
	private String cy_phone;
	private String cy_email;
	private String cy_nickname; 
	private String cy_signuptime; //가입날짜 추가
	private int cy_cash;
	
	public MemberDto() {}

	public MemberDto(int cy_num, String cy_id, String cy_password, String cy_name, String cy_phone, String cy_email,
			String cy_nickname, String cy_signuptime, int cy_cash) {
		super();
		this.cy_num = cy_num;
		this.cy_id = cy_id;
		this.cy_password = cy_password;
		this.cy_name = cy_name;
		this.cy_phone = cy_phone;
		this.cy_email = cy_email;
		this.cy_nickname = cy_nickname;
		this.cy_signuptime = cy_signuptime;
		this.cy_cash = cy_cash;
	}

	public int getCy_num() {
		return cy_num;
	}

	public void setCy_num(int cy_num) {
		this.cy_num = cy_num;
	}

	public String getCy_id() {
		return cy_id;
	}

	public void setCy_id(String cy_id) {
		this.cy_id = cy_id;
	}

	public String getCy_password() {
		return cy_password;
	}

	public void setCy_password(String cy_password) {
		this.cy_password = cy_password;
	}

	public String getCy_name() {
		return cy_name;
	}

	public void setCy_name(String cy_name) {
		this.cy_name = cy_name;
	}

	public String getCy_phone() {
		return cy_phone;
	}

	public void setCy_phone(String cy_phone) {
		this.cy_phone = cy_phone;
	}

	public String getCy_email() {
		return cy_email;
	}

	public void setCy_email(String cy_email) {
		this.cy_email = cy_email;
	}

	public String getCy_nickname() {
		return cy_nickname;
	}

	public void setCy_nickname(String cy_nickname) {
		this.cy_nickname = cy_nickname;
	}

	public String getCy_signuptime() {
		return cy_signuptime;
	}

	public void setCy_signuptime(String cy_signuptime) {
		this.cy_signuptime = cy_signuptime;
	}

	public int getCy_cash() {
		return cy_cash;
	}

	public void setCy_cash(int cy_cash) {
		this.cy_cash = cy_cash;
	}

	@Override
	public String toString() {
		return "MemberDto [cy_num=" + cy_num + ", cy_id=" + cy_id + ", cy_password=" + cy_password + ", cy_name="
				+ cy_name + ", cy_phone=" + cy_phone + ", cy_email=" + cy_email + ", cy_nickname=" + cy_nickname
				+ ", cy_signuptime=" + cy_signuptime + ", cy_cash=" + cy_cash + "]";
	}
	
	
	
	
}
