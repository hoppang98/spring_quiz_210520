package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.FavoriteDAO;
import com.quiz.lesson06.model.Favorite;

@Service
public class FavoriteBO {
	
	@Autowired
	private FavoriteDAO favoriteDAO; //3
	
	public void addFavorite(String name, String url) { //1
		favoriteDAO.insertFavorite(name, url); // 4
	}
	
	public List<Favorite> getFavoriteList() {
		return favoriteDAO.selectFavoriteList();
	}
	
	
	public Favorite getFavoriteByUrl(String url) {
		return favoriteDAO.selectFavoriteByUrl(url);
	}
	
	public int deleteFavoriteById(int id) {
		return favoriteDAO.deleteFavoriteById(id);
	}
}
