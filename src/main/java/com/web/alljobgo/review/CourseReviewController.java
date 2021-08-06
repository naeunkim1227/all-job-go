package com.web.alljobgo.review;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.web.alljobgo.review.service.CourseReviewService;
import com.web.alljobgo.train.domain.SearchVO;

@Controller
@RequestMapping(value = "/review")
public class CourseReviewController {
	
	private final CourseReviewService courseReviewService;
	
	public CourseReviewController(CourseReviewService courseReviewService) {
		this.courseReviewService = courseReviewService;
	}
	
	@GetMapping(value = "")
	public String getReview(Model model) throws Exception {
		return "review/courseReview";
	}
	
	@GetMapping(value="/data"/*, produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf8"*/)
//	@ResponseBody
	public String getData(Model model, SearchVO searchVO) throws Exception{
		
		JSONParser jsonParser = new JSONParser();
		JSONObject obj = (JSONObject)jsonParser.parse(courseReviewService.review(searchVO));
		ArrayList<String> comments = new ArrayList<String>();
		obj.get("epilogueList");
		
		JSONArray jsonAr = (JSONArray)obj.get("epilogueList");
		
		for(int i=0;i<jsonAr.size();i++) {
			JSONObject temp = (JSONObject)jsonAr.get(i); 
			
			comments.add((String)temp.get("pstcptCn"));
		}
		
		model.addAttribute("comments", comments);
		
		//return comments.toString();
		return "review/courseReview";
	}

}
