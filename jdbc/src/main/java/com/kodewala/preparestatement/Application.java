package com.kodewala.preparestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Application {
	public static void main( String[] args )
    {
		long start = System.currentTimeMillis();
		System.out.println("Application.main()");
        //Register Driver
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //dynamic class loading
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ 27th_oct_batch", "root", "SP25@hit");
			
			
			String sql = "insert into user_info(user_name,user_id,status) values(?,?,?)";
			
			PreparedStatement ps =con.prepareStatement(sql); //will be stored in ResultSet
			
			for(int i=0; i< 10; i++) {
				ps.setString(1,"agnish" + i);
				ps.setString(2,"agni@123" + i);
				ps.setString(3,"CREATED");
				
				int result = ps.executeUpdate();
				System.out.println("Record inserted: " + result);
			}
			
		} catch (Exception  e) {
			
			e.printStackTrace();
		}
    	
    	long end = System.currentTimeMillis();
    	System.out.println("Time taken : " + (end-start));
    }
    	
}
