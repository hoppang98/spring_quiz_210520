package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.NewSellerBO;
import com.quiz.lesson04.model.NewSeller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class NewSellerController {
	
	@Autowired
	private NewSellerBO newSellerBO;
	
	// 요청 url : http://localhost/lesson04/quiz01/1
	@GetMapping("/1")
	public String quiz01_1() {
		return "lesson04/addSeller";
	}
	
	@PostMapping("/add_seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam("profileImage") String profileImage,
			@RequestParam("temperature") double temperature
			) {
		
		newSellerBO.addNewSeller(nickname, profileImage, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	
	// 가장 최근에 추가된 seller의 정보
	// 검색 후 출력
	// 요청 URL : http://localhost/lesson04/quiz01/seller_info
	// 요청 URL : http://localhost/lesson04/quiz01/seller_info?id=1
	@GetMapping("/seller_info")
	public String getLastSeller(
			Model model,
			@RequestParam(value="id", required=false) Integer id
			) {
		
		NewSeller seller = null;
		if (id = null) {
			seller = newSellerBO.getLastNewSeller();
		} else {
			seller = newSellerBO.getNewSellerById(id);
		}	
		
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		
		return "lesson04/lastSeller";
	}
}
