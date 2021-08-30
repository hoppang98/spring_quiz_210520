package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.EstateBO;
import com.quiz.lesson03.model.Estate;

@RequestMapping("/lesson03")
@RestController
public class EstateRestController {
	
	@Autowired
	private EstateBO EstateBO;
	
	@RequestMapping("/quiz01/1")
	public Estate quiz01(
			@RequestParam(value="id") int id
			) {
		Estate estate = EstateBO.getEstateById(id);
		return estate;
	}
	
	
	
	// http://localhost/lesson03/quiz01/2?rent_price=90
	@RequestMapping("/quiz01/2")
	public List<Estate> quiz01_2(
			@RequestParam("rent_price") int rentPrice) {
		List<Estate> EstateList = EstateBO.getEstateListByRentPrice(rentPrice);
		return EstateList;
	}
	
	
	
	
	// http://localhost/lesson03/quiz01/3?area=90&price=130000
	@RequestMapping("/quiz01/3")
	public List<Estate> quiz01_3(
			@RequestParam(value = "area", required=true) int area,
			@RequestParam(value = "price", required=true) int price){
		List<Estate> EstateList = EstateBO.getEstateListByAreaAndPirce(area, price);
		return EstateList;
	}
	
	
	
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
