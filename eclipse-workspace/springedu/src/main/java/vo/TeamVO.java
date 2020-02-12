package vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class TeamVO {
	String teamName;
	List<TeamMemberVO> teamMember;
	public String getTeamName() {
		return teamName;
	}
	public List<TeamMemberVO> getTeamMember() {
		return teamMember;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public void setTeamMember(List<TeamMemberVO> teamMember) {
		this.teamMember = teamMember;
	}
	
}
