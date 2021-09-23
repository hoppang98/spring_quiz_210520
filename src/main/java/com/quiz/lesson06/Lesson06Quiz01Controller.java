package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.FavoriteBO;
import com.quiz.lesson06.model.Favorite;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {
	// 만든 순서 : controller-addFavor.jsp-model-bo-dao-controller(autowired)-xml-controller(requestMapping/favorite_list)-xml(select)-dao-bo-favoriteList.jsp
	
	@Autowired
	private FavoriteBO favoriteBO; // 5
	
	@RequestMapping("/add_favorite_view")
	public String addFavoriteView() {
		return "lesson06/addFavorite";
	}
	
	// submit : @Controller -> view 리턴(화면으로 보인다)
	// ajax : @Contoller + @ResponseBody -> String, JSON (데이터만 보낸다)
	
	@ResponseBody
	@PostMapping("/add_favorite")
	public Map<String, String> addFavorite(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		//DB insert
		favoriteBO.addFavorite(name, url);
		
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		
		
		return result;
	}
	
	@RequestMapping("/favorite_list")
	public String favoriteList(Model model) {
		//DB에서 즐겨찾기 목록을 SELECT
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		
		// model 객체에 세팅한다
		model.addAttribute("favoriteList", favoriteList);
		
		return "lesson06/favoriteList";
	}
	
	
	@PostMapping("/check_duplication_url")
	@ResponseBody
	public Map<String, Boolean> checkDuplicationUrl(
			@RequestParam("url") String url) {
		
		// url DB 조회 중복 체크
		Favorite favorite = favoriteBO.getFavoriteByUrl(url);
		
		// 결과 map 구성
		Map<String, Boolean> result = new HashMap<>();
		result.put("isDuplication", false);
		
		if (favorite != null) {
			result.put("isDuplication", true);
		}
		
		return result; // 이 결과가 @ResponseBody에 담겨서 내려간다.
	}
	
	
	@PostMapping("/delete_favorite")
	@ResponseBody
	public Map<String, String> deleteFavorite(
			@RequestParam("favorite_id") int id) {
		
		// DB delete - id
		int deletedRow = favoriteBO.deleteFavoriteById(id);
		// deletedRow가 0보다 크면 성공
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		if (deletedRow == 0) {
			result.put("result", "fail");
		}
		
		return result;
	}
	
}

