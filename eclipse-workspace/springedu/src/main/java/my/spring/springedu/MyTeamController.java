package my.spring.springedu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.TeamMemberVO;
import vo.TeamVO;

@Controller
public class MyTeamController {
	
	@RequestMapping(value = "/myteam/xml", produces = "application/xml; charset=UTF-8")
	@ResponseBody
	public TeamVO getXML() {
		List<TeamMemberVO> list = new ArrayList<>();
		TeamMemberVO tmvo1 = new TeamMemberVO();
		TeamMemberVO tmvo2 = new TeamMemberVO();
		TeamMemberVO tmvo3 = new TeamMemberVO();
		TeamVO tvo = new TeamVO();
		tmvo1.setName("황지원");
		tmvo1.setNicName("반장");
		list.add(tmvo1);
		tmvo2.setName("정해림");
		tmvo2.setNicName("해림님");
		list.add(tmvo2);
		tmvo3.setName("김수이");
		tmvo3.setNicName("누님");
		list.add(tmvo3);
		
		tvo.setTeamName("JAVAS");
		tvo.setTeamMember(list);
		
		return tvo;
		
	}
	
	@RequestMapping(value = "/myteam/json", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public TeamVO getJSON() {
		List<TeamMemberVO> list = new ArrayList<>();
		TeamMemberVO tmvo1 = new TeamMemberVO();
		TeamMemberVO tmvo2 = new TeamMemberVO();
		TeamMemberVO tmvo3 = new TeamMemberVO();
		TeamVO tvo = new TeamVO();
		tmvo1.setName("황지원");
		tmvo1.setNicName("앤트맨");
		list.add(tmvo1);
		tmvo2.setName("정해림");
		tmvo2.setNicName("스파이더맨");
		list.add(tmvo2);
		tmvo3.setName("김수이");
		tmvo3.setNicName("헬라");
		list.add(tmvo3);
		
		tvo.setTeamName("JAVAS");
		tvo.setTeamMember(list);
		
		return tvo;
		
	}
	

}
