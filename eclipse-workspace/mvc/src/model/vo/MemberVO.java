package model.vo;

public class MemberVO {
	String name;
	String telNumber;
	String email;
	String pw;
	
	public MemberVO() {}
	
	public MemberVO(String name,String telNumber,String email,String pw){
		this.name = name;
		this.telNumber = telNumber;
		this.email = email;
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getPw() {
		return pw;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
