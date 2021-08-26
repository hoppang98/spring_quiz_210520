package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.dao.StoreDAO;
import com.quiz.lesson02.model.Store;

@Service
public class StoreBO { // 데이터를 가공 business object
	@Autowired
	private StoreDAO storeDAO;
	
	public List<Store> getStoreList() {
		return storeDAO.selectStoreList();
	}
}
