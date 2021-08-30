package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.dao.EstateDAO;
import com.quiz.lesson03.model.Estate;

@Service
public class EstateBO {
	@Autowired
	private EstateDAO estateDAO;
	
	public Estate getEstateById(int id) {
		return estateDAO.selectEstateById(id);
	}
	
	public List<Estate> getEstateListByRentPrice(int rentPrice) {
		return estateDAO.selectEstateListByRentPrice(rentPrice);
	}
	
	public List<Estate> getEstateListByAreaAndPirce(int area, int price) {
		return estateDAO.selectEstateListByAreaAndPirce(area, price);
	}
	
	public int addEstate(Estate estate) {
		return estateDAO.insertEstate(estate);
	}
	
	public int addEstateAsField(int realtorId, String address, int area, String type, int price, int rentPrice) {
		return estateDAO.insertEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
}
