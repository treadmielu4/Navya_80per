package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StockDao;
import com.example.demo.model.Stock;

@Service
public class StockService {
	
	@Autowired
	StockDao stockDao;
	
	public List<Stock> getAllStock()
	{
		List<Stock> stocklist=stockDao.getAllStock();
		return stocklist;
		
	}

	public Stock searchStock(String id, String name, String fprice, String tprice, String fvolume, String tvolume,
			String fdate, String tdate) {
		// TODO Auto-generated method stub
		Stock stock=stockDao.searchStock(id,name,fprice,tprice,fvolume,tvolume,fdate,tdate);
		return stock;
	}

	public List<Stock> orderByPrice() {
		// TODO Auto-generated method stub
		return stockDao.orderByPrice();
	}
	
	

}
