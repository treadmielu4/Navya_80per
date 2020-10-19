package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
	public Connection getConnection() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Retrieving properties from db.properties
        String url="jdbc:mysql://localhost:8080/?user=root";
        String username="root";
        String password="qwerty";
        
        Connection connection=null;
        //Establishing connection and catching exception if connection is not established or url not found
        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

	
	
}
