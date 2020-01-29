package model.vo;

public class LottoVO {
	//VO 클래스의 경우 직접 멤버에 접근하지 못하게 private 접근자를 많이 사용한다.
	private String msg;
	private String imgURL;
	private boolean linkDisplay;
	
	public String getMsg() {
		return msg;
	}
	public String getImgURL() {
		return imgURL;
	}
	public boolean isLinkDisplay() {
		return linkDisplay;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public void setLinkDisplay(boolean linkDisplay) {
		this.linkDisplay = linkDisplay;
	}
	
}
