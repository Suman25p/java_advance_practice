package com.kodewala.jdbc.batchproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Application {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			//Register JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//created connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ 27th_oct_batch", "root", "SP25@hit");
			
			String validSql = "INSERT INTO customer_info VALUES(?,?,?,?,?,?,?,?,?,?)";

			String invalidSql = "INSERT INTO customer_info_invalid VALUES(?,?,?,?,?)";
			
			PreparedStatement validPs = con.prepareStatement(validSql);
			
			PreparedStatement invalidPs = con.prepareStatement(invalidSql);
			
			//csv file uploading
			BufferedReader br = new BufferedReader(new FileReader("customer_details.csv"));
			
			String line;
			
			br.readLine(); //ignore column name
			
			//created batchsize
			int batchSize = 250;
			int count=0;
			
			while((line = br.readLine()) != null) { //process actual data
				String[] data = line.split(",");
				String customer_id = data[0];
				String first_name = data[1];
				String last_name = data[2];
				String email = data[3];
				String phone = data[4];
				String city = data[5];
				String state = data[6];
				String country = data[7];
				String signup_date = data[8];
				String status = data[9];
				
				boolean valid = true;
				
				String reason = " ";
				
				//customer Id validation
				if(customer_id == null || customer_id.trim().isEmpty()) {

				    valid = false;
				    reason = "Customer ID Missing";

				}
				else if(!customer_id.matches("\\d+")) {

				    valid = false;
				    reason = "Customer ID Not Numeric";

				}
				
				//First name validation 
				if(first_name == null || first_name.trim().isEmpty()) {
					valid = false;
					reason = "Missing First Name";
				}
				
				//Last name validation 
				if(last_name == null || last_name.trim().isEmpty()) {
					valid = false;
					reason = "Missing Last Name";
				}
				
				//Email validation
				if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
					valid = false;
					reason = "Invalid Email";
				}
				
				if (valid) {

					validPs.setInt(1, Integer.parseInt(customer_id));
					validPs.setString(2, first_name);
					validPs.setString(3, last_name);
					validPs.setString(4, email);
					validPs.setString(5, phone);
					validPs.setString(6, city);
					validPs.setString(7, state);
					validPs.setString(8, country);
					validPs.setDate(9, Date.valueOf(signup_date));
					validPs.setString(10, status);

					validPs.addBatch();
				}else {

					invalidPs.setString(1, customer_id);
					invalidPs.setString(2, first_name);
					invalidPs.setString(3, last_name);
					invalidPs.setString(4, email);
					invalidPs.setString(5, reason);

					invalidPs.addBatch();
				}
				count++;
				
				//Execute batch every 20 records
				if(count % batchSize == 0) {
					System.out.println("Executing batch...");
					validPs.executeBatch();
					invalidPs.executeBatch();
				}
			}
			
			//execute remaining batch
			System.out.println("Executing remaining batch...");
			validPs.executeBatch();
			invalidPs.executeBatch();
			
			System.out.println("CSV Upload completed!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		long end = System.currentTimeMillis();

		System.out.println("Time taken : " + (end-start));
	}

}
