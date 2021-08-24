package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/quiz01")
@Controller
public class Lesson01Quiz01Controller {
	// 요청 URL : http://localhost:80/lesson01/quiz01/1
	@RequestMapping("/1")
	@ResponseBody
	public String text() {
		String text = "<h1>테스트 프로젝트 완성<h1><h3>해당 프로젝트를 통해서 문제 풀이를 진행합니다.<h3>";
		return text;
	}
	
	
	
	// 요청 URL : http://localhost:80/lesson01/quiz01/2
	@ResponseBody
	@RequestMapping("/2")
	public Map<String, Integer> quiz02() {
		Map<String, Integer> score = new HashMap<>();
		score.put("국어", 80);
		score.put("수힉", 90);
		score.put("영어", 85);
		return score;
	}
}