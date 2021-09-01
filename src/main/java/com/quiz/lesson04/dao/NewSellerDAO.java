package com.quiz.lesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson04.model.NewSeller;

@Repository
public interface NewSellerDAO {
	public void insertNewSeller(
			@Param("nickname") String nickname,
			@Param("profileImage") String profileImage,
			@Param("temperature") double temperature
			);
	
	public NewSeller selectLastNewSeller();
	
	public NewSeller selectSellerById(int id);
}
