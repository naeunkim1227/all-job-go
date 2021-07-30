package com.web.alljobgo.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/review")
public class CourseReviewController {
	
	@GetMapping(value = "/")
	public String getReview() {
		
		return "review/courseReview";
	}

}
