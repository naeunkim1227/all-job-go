package com.web.alljobgo.calender;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String seeCalender(Model model) throws Exception{
			System.out.println("씨캘 호출");
			//호출할때...id정보 가져가서....관심과정,학원 가지고 와야함....
			
			model.addAttribute("FavoriteVO", service.getfavclass());
			
			return "calender/seeCalender";
		}
	
	/*
	@RequestMapping(value = "/seeCalender2",method = RequestMethod.GET)
	public String seeCalender2(Model model) throws Exception{
			System.out.println("씨캘 호출");
			
			
			model.addAttribute("FavoriteVO", service.getfavclass());
			
			return "calender/seeCalender2";
		}
	
	*/
	
	@RequestMapping(value = "/seeCalender2",method = RequestMethod.GET)
	public String getAPIDATE(Model model) throws Exception {
		model.addAttribute("FavoriteVO", service.getfavclass());
		
		
		return "calender/seeCalender2";
	}
	
}
