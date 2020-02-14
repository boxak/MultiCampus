package my.spring.springedu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MeetingDAO;
import vo.MeetingVO;

@Controller
public class MeetingController {
	@Autowired
	MeetingDAO dao;
	@RequestMapping("/listAll")
	public ModelAndView listAll() {
		System.out.println("Meeting listAll - Mybatis");
		ModelAndView mav = new ModelAndView();
		List<MeetingVO> list = dao.listAll();
		mav.addObject("meetingTable",list);
		mav.setViewName("meetingView");
		return mav;
	}
	@RequestMapping("/find")
	public ModelAndView search(String keyword) {
		System.out.println("Meeting search - Mybatis");
		ModelAndView mav = new ModelAndView();
		List<MeetingVO> list = dao.search(keyword);
		mav.addObject("meetingTable",list);
		mav.setViewName("meetingView");
		return mav;
	}
	@RequestMapping("/add")
	public ModelAndView insert(MeetingVO vo) {
		dao.insert(vo);
		ModelAndView mav = new ModelAndView();
		List<MeetingVO> list = dao.listAll();
		mav.addObject("meetingTable",list);
		mav.setViewName("meetingView");
		return mav;
	}
	@RequestMapping(value="/delete")
	public ModelAndView delete(int id) {
		System.out.println("Meeting delete - Mybatis");
		dao.delete(id);
		ModelAndView mav = new ModelAndView();
		List<MeetingVO> list = dao.listAll();
		mav.addObject("meetingTable",list);
		mav.setViewName("meetingView");
		return mav;
	}
	@RequestMapping("/update")
	public ModelAndView update(int id) {
		System.out.println("Meeting update - Mybatis");
		dao.update(id);
		ModelAndView mav = new ModelAndView();
		List<MeetingVO> list = dao.listAll();
		mav.addObject("meetingTable",list);
		mav.setViewName("meetingView");
		return mav;
	}
}
