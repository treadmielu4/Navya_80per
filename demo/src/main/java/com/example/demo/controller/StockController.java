package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;


@RestController
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@GetMapping("/listallstock")
		public List<Stock> displayStock()
		{
			return stockService.getAllStock();
		
		}
	
	@GetMapping("/searchstock/stockid/{id}/stockname/{name}/f_price/{fprice}/t_price/{tprice}/f_volume/{fvolume}/t_volume/{tvolume}/f_date/{fdate}/t_date/{tdate}")
	public  Stock searchStock(@PathVariable String id,@PathVariable String name,@PathVariable String fprice,@PathVariable String tprice,@PathVariable String fvolume,@PathVariable String tvolume,@PathVariable String fdate,@PathVariable String tdate)
	{
		
		return stockService.searchStock(id,name,fprice,tprice,fvolume,tvolume,fdate,tdate);
		
	}
	
	@GetMapping("/stockPrice")
	public List<Stock> topFiveStock()
	{
		return stockService.orderByPrice();
		
	}
}
