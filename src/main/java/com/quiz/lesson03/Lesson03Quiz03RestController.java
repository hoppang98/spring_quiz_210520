package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.EstateBO;

@RequestMapping("/lesson03")
@RestController
public class Lesson03Quiz03RestController {
	@Autowired
	private EstateBO EstateBO;
	
	//http://localhost/lesson03/quiz03?id=8&type=전세&price=70000
	@RequestMapping("/quiz03")
	public String quiz03(
			@RequestParam(value="id") int id,
			@RequestParam(value="type") String type,
			@RequestParam(value="price") int price) {
		
		int rowCount = EstateBO.updateEstate(id, type, price);
		return "수정 성공 : " + rowCount;
		
	}
}
