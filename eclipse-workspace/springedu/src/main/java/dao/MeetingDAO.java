package dao;
import java.util.List;

import vo.MeetingVO;
public interface MeetingDAO {
	public List<MeetingVO> listAll();
	public boolean insert(MeetingVO vo);
	public List<MeetingVO> search(String keyword);
	public boolean delete(int id);	
	public boolean update(int id);
}
