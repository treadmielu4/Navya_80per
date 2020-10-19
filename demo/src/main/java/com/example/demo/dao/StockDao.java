package com.example.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Stock;

@Component
public class StockDao {

	DBHandler dbHandler=new DBHandler();
	
	public List<Stock> getAllStock()
	{
		List<Stock> stocklist=new ArrayList<Stock>();
		Connection conn=dbHandler.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			 String sqlquery = "select * from stock ;";
		        ResultSet res = stmt.executeQuery(sqlquery);
		        while ( res.next() ) {
		        	Stock stock=new Stock();
		        	stock.setStock_id(res.getInt("stock_id"));
		        	stock.setStockname(res.getString("stockname"));
		        	stock.setPrice(res.getInt("price"));
		        	stock.setVolume(res.getInt("volume"));
		        	stock.setDate(res.getDate("date"));

		        	stocklist.add(stock);
	                 
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return stocklist;
		
	}

	public Stock searchStock(String id, String name, String fprice, String tprice, String fvolume, String tvolume,
			String fdate, String tdate) {
		Connection conn=dbHandler.getConnection();
		Stock stock=new Stock();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			 String sqlquery = "select * from stock where stock_id='" + id +"' and stockname='"+ name +"' and price between '"+fprice+"' and '"+tprice+"' and volume between '"+fvolume+"' and '"+tvolume+"' and date between '"+fdate+"' and '"+tdate+"';";
		        ResultSet res = stmt.executeQuery(sqlquery);
		        while ( res.next() ) {
		        	
		        	stock.setStock_id(res.getInt("stock_id"));
		        	stock.setStockname(res.getString("stockname"));
		        	stock.setPrice(res.getInt("price"));
		        	stock.setVolume(res.getInt("volume"));
		        	stock.setDate(res.getDate("date"));

		        	
	                 
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return stock;
	}

	public List<Stock> orderByPrice() {
		// TODO Auto-generated method stub
		List<Stock> stocklist=new ArrayList<Stock>();
		Connection conn=dbHandler.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			 String sqlquery = "SELECT TOP 5 stock_id, stockname, price, volume, date FROM stock ORDER BY price; ";
		        ResultSet res = stmt.executeQuery(sqlquery);
		        while ( res.next() ) {
		        	Stock stock=new Stock();
		        	stock.setStock_id(res.getInt("stock_id"));
		        	stock.setStockname(res.getString("stockname"));
		        	stock.setPrice(res.getInt("price"));
		        	stock.setVolume(res.getInt("volume"));
		        	stock.setDate(res.getDate("date"));

		        	stocklist.add(stock);
	                 
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return stocklist;
	}
}
