package my.spring.springnews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.NewsDAO;
import vo.NewsVO;

@Controller
public class NewsController {
	@Autowired NewsDAO dao;
	@RequestMapping(value = "/newsmain", method = RequestMethod.GET)
	public ModelAndView listAll() {
		System.out.println("News - listAll - SpringMVC");
		ModelAndView mav = new ModelAndView();
		mav.addObject("viewlist", dao.listAll());
		mav.setViewName("news");
		return mav;
	}
	@RequestMapping(value = "/listOne", method = RequestMethod.GET)
	public ModelAndView listOne(int id) {
		System.out.println("News - listOne - SpringMVC");
		System.out.println("ID : "+id);
		ModelAndView mav = new ModelAndView();
		mav = listAll();
		NewsVO vo = dao.listOne(id);
		vo.setCnt(vo.getCnt()+1);
		mav.addObject("view", vo);
		dao.update(vo);
		//System.out.println(dao.listOne(id));
		mav.setViewName("news");
		return mav;
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(int id) {
		System.out.println("News - delete - SpringMVC");
		System.out.println("delete : "+dao.delete(id));
		ModelAndView mav = new ModelAndView();
		mav = listAll();
		mav.setViewName("news");
		return mav;
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(String key,String searchType) {
		System.out.println("News - search - SpringMVC");
		System.out.println("key : "+key+", searchType : "+searchType);
		ModelAndView mav = new ModelAndView();
		mav.addObject("viewlist", dao.search(key, searchType));
		mav.setViewName("news");
		return mav;
	}
	@RequestMapping(value = "/listWriter", method = RequestMethod.GET)
	public ModelAndView listWriter(String writer) {
		System.out.println("News - listWriter - SpringMVC");
		ModelAndView mav = new ModelAndView();
		mav.addObject("viewlist", dao.listWriter(writer));
		mav.setViewName("news");
		//System.out.println(writer);
		return mav;
	}
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public ModelAndView insert(NewsVO vo) {
		System.out.println("News - insert - SpringMVC");
		System.out.println("insert : "+dao.insert(vo));
		ModelAndView mav = new ModelAndView();
		mav = listAll();
		mav.setViewName("news");
		return mav;
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("view")NewsVO vo) {
		System.out.println("News - update - SpringMVC");
		System.out.println(vo);
		dao.update(vo);
		ModelAndView mav = new ModelAndView();
		mav = listAll();
		mav.setViewName("news");
		return mav;
	}
}
