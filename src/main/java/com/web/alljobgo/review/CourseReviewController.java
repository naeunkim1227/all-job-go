package com.web.alljobgo.review;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/review")
public class CourseReviewController {
	
	@GetMapping(value = "/")
	public String getReview(Model model) throws Exception {
		
		String url = "https://www.hrd.go.kr/hrdp/co/pcobo/PCOBO0100P.do?tracseId=AIG20200000294161&tracseTme=1&crseTracseSe=500020061830&trainstCstmrId=#";
		
		Document doc = Jsoup.connect(url).get();
		
		Elements ele = doc.select(".commentReviewArea .commentReview .body .ment");
		
		model.addAttribute("test1", ele);
		
		return "review/courseReview";
	}

}
