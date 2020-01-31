package model.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MeetingVO {
	private String id;
	private String name;
	private String title;
	private String meetingDate;
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTitle() {
		return title;
	}
	public String getMeetingDate() {
		return meetingDate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setMeetingDate(String meetingDate){
		/*System.out.println("날짜 : "+meetingDate);
		String pattern = "yyyy-MM-dd hh:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			Date date = sdf.parse(meetingDate);
			this.meetingDate = sdf.format(date);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}*/
		this.meetingDate = meetingDate;
	}
	
	@Override
	public String toString() {
		return "아이디 : "+this.id+", 이름  : "+this.name
				+", 제목 : "+this.title+", 미팅날짜 : "+this.meetingDate;
	}
}
