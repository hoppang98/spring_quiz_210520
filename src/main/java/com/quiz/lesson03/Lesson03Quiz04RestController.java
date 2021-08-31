package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.EstateBO;

@RequestMapping("/lesson03")
@RestController
public class Lesson03Quiz04RestController {
	@Autowired
	private EstateBO EstateBO;
	
	//http://localhost/lesson03/quiz04?id=20
	@RequestMapping("/quiz04")
	public String quiz04(
			@RequestParam(value="id") int id) {
		int rowCount = EstateBO.deleteEstateById(id);
		return "삭제 성공: " + rowCount;
	}
}
