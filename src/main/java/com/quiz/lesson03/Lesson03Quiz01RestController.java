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
public class Lesson03Quiz01RestController {
	
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

}
