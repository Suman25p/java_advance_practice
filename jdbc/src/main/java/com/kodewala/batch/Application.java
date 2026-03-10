package com.kodewala.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Application {
	public static void main( String[] args )
    {
		long start = System.currentTimeMillis();
        //Register Driver
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //dynamic class loading
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ 27th_oct_batch", "root", "SP25@hit");
			
			
			String sql = "insert into user_info(user_name,user_id,status) values(?,?,?)";
			
			PreparedStatement ps =con.prepareStatement(sql); //will be stored in PreparedStatement
			
			int batchSize = 50;
			for(int i=1; i< 100; i++) {
				ps.setString(1,"agnish" + i);
				ps.setString(2,"agni@123" + i);
				ps.setString(3,"CREATED");
				ps.addBatch();
				System.out.println("Adding to batch!!!");
				
				if(i % batchSize == 0) {
				
				System.out.println("Executing the batch of " + i);
				ps.executeBatch();
				}
			}
			System.out.println("Executing the remaining query!");
			ps.executeBatch();
			
		} catch (Exception  e) {
			
			e.printStackTrace();
		}
    	long end = System.currentTimeMillis();
    	System.out.println("Time taken : " + (end-start));
    }
    	
}
