package com.web.alljobgo.calendar;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.web.alljobgo.calendar.domain.HrdSearchVO;
import com.web.alljobgo.calendar.domain.FavoriteVO;
import com.web.alljobgo.calendar.service.CalendarService;
import com.web.alljobgo.train.domain.SearchVO;
import com.web.alljobgo.user.domain.userVO;

@Controller
@RequestMapping("/calendar/*")
public class CalendarController {
	
	@Inject
	private CalendarService service;
	

	@RequestMapping(value = "/seecalendar3",method = RequestMethod.GET)
	public String seecalendar(Model model,@ModelAttribute("id") String id,HttpSession session) throws Exception{
			System.out.println("씨캘 호출");
			//호출할때...id정보 가져가서....관심과정,학원 가지고 와야함....
			session.setAttribute(id, "admin");
			System.out.println(session.getAttribute(id));
			model.addAttribute("FavoriteVO", service.getfavclass());
			
			return "calendar/seecalendar3";
		}

	
	@RequestMapping(value = "/seecalendar",method = RequestMethod.GET)
	public String getAPI(Model model,HttpServletRequest request,@ModelAttribute("hvo") HrdSearchVO hvo) throws Exception {
		
		
		HttpSession session = request.getSession();
		String id = "admin";
		session.setAttribute("id", id);
		
		Vector totallist =  service.getapi(id);
		
		model.addAttribute("classlist", totallist.get(0));
		model.addAttribute("academylist", totallist.get(1));
		
		return "calendar/seecalendar";
	}
	
	

}
