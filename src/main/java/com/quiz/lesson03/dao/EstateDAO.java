package com.quiz.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.model.Estate;

@Repository
public interface EstateDAO {
	public Estate selectEstateById(int id);
	
	public List<Estate> selectEstateListByRentPrice(int rentPrice);
	
	public List<Estate> selectEstateListByAreaAndPirce(
			// map으로 만들어서 넘긴다
			@Param("area") int area, 
			@Param("price") int price);
	
	public int insertEstate(Estate estate);
	
	public int insertEstateAsField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") int rentPrice);
}
