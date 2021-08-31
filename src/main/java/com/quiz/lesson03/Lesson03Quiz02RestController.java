package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.EstateBO;
import com.quiz.lesson03.model.Estate;

@RequestMapping("/lesson03")
@RestController
public class Lesson03Quiz02RestController {
	
	@Autowired
	private EstateBO EstateBO;
	
	// http://localhost/lesson03/quiz02/1
	@RequestMapping("/quiz02/1")
	public String quiz02_1() {
		Estate estate = new Estate();
		estate.setRealtorId(3);
		estate.setAddress("푸르지용 리버 303동 1104호");
		estate.setArea(89);
		estate.setType("매매");
		estate.setPrice(100000);
		
		int rowCount = EstateBO.addEstate(estate);
		return "입력 성공 : " + rowCount;
	}
	
	
	// http://localhost/lesson03/quiz02/2?realtorId=5
	@RequestMapping("/quiz02/2")
	public String quiz02_2(
			@RequestParam(value="realtorId") int realtorId
			) {
		int rowCount = EstateBO.addEstateAsField(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "입력 성공 : " + rowCount;
	}
}
