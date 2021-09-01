package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.dao.NewSellerDAO;
import com.quiz.lesson04.model.NewSeller;

@Service
public class NewSellerBO {
	
	@Autowired
	private NewSellerDAO newSellerDAO;
	
	public void addNewSeller(String nickname, String profileImage, double temperature)  {
		newSellerDAO.insertNewSeller(nickname, profileImage, temperature);
	}
	
	public NewSeller getLastNewSeller() {
		return newSellerDAO.selectLastNewSeller();
	}
	
	public NewSeller getNewSellerById(int id) {
		return newSellerDAO.selectSellerById(id);
	}
}
