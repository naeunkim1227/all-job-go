package com.web.alljobgo.review;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.alljobgo.review.service.CourseReviewService;

@Controller
@RequestMapping(value = "/review")
public class CourseReviewController {
	
	private final CourseReviewService courseReviewService;
	
	public CourseReviewController(CourseReviewService courseReviewService) {
		this.courseReviewService = courseReviewService;
	}
	
	@RequestMapping(value = "")
	public String getReview(Model model) throws Exception {
		return "review/courseReview";
	}
	
	@RequestMapping(value="/data", method=RequestMethod.GET)
			/*, produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf8"*/
//	@ResponseBody
	public String getData(@RequestParam("conId") String conId, Model model) throws Exception{
		
		
		JSONParser jsonParser = new JSONParser();
		JSONObject obj = (JSONObject)jsonParser.parse(courseReviewService.review(conId));
		
		
		ArrayList<String> comments = new ArrayList<String>();
		
		obj.get("epilogueList");
		
		JSONArray jsonAr = (JSONArray)obj.get("epilogueList");
		
		for(int i=0;i<jsonAr.size();i++) {
			JSONObject temp = (JSONObject)jsonAr.get(i); 
			
			comments.add((String)temp.get("pstcptCn"));
		}
		
		model.addAttribute("comments", comments);
		
		//학원 정보	
		ArrayList<String> acaInformation = new ArrayList<String>();
		
		JSONObject info = (JSONObject)jsonParser.parse(courseReviewService.acainfor(conId));
		
		JSONObject jsonInfo1 = (JSONObject)info.get("tracseList");
		
		JSONArray jsonInfo2 = (JSONArray)jsonInfo1.get("result");
		
		System.out.println("@@@@@@@@@@@@@@@@@@@");
		System.out.println(jsonInfo2);
		
		for(int j=0;j<jsonInfo2.size();j++) {
			JSONObject objInfo = (JSONObject)jsonInfo2.get(j);
			
			acaInformation.add((String)objInfo.get("trainst_nm_str"));
			acaInformation.add((String)objInfo.get("tracse_nm"));
			
		}
		
		model.addAttribute("acaInformation",acaInformation);
		
		//return comments.toString();
		return "review/courseReview";
	}

}
