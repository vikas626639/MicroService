package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.repository.StockRepository;
import com.nit.repository.Stock_Details;

@Service
public class StockPriceService implements Stockprice_interface {
	
	@Autowired
	private StockRepository repo;

	@Override
	public double getStockprice(String companyName) {
		//use repository
		Stock_Details entity = repo.findByCompanyname(companyName);
		System.out.println(entity);
		return entity.getStockprice();
	}
}
