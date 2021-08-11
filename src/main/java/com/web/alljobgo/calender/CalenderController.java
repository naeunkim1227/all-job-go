package com.web.alljobgo.calender;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.web.alljobgo.calender.domain.HrdSearchVO;
import com.web.alljobgo.calender.domain.FavoriteVO;
import com.web.alljobgo.calender.service.CalenderService;
import com.web.alljobgo.train.domain.SearchVO;

@Controller
@RequestMapping("/Calender/*")
public class CalenderController {
	
	@Inject
	private CalenderService service;
	

	@RequestMapping(value = "/seeCalender",method = RequestMethod.GET)
	public String seeCalender(Model model,@ModelAttribute("id") String id,HttpSession session) throws Exception{
			System.out.println("씨캘 호출");
			//호출할때...id정보 가져가서....관심과정,학원 가지고 와야함....
			
			session.setAttribute(id, "admin");
			
			System.out.println(session.getAttribute(id));
			
			model.addAttribute("FavoriteVO", service.getfavclass());
			
			return "calender/seeCalender";
		}

	
	@RequestMapping(value = "/seeCalender2",method = RequestMethod.GET)
	public String getAPI(Model model,HttpServletRequest request) throws Exception {
        
		HttpSession session = request.getSession();
		String id = "admin";
		session.setAttribute("id", id);
		
		System.out.println(session.getAttribute(id));
		
		System.out.println("id의 문제?" + id);
		
		System.out.println("이겁니다" + service.getapi(id));
		model.addAttribute("favlist", service.getapi(id));
		
		
		return "calender/seeCalender2";
	}
	
}
