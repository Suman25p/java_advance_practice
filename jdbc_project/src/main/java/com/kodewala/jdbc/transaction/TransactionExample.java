package com.kodewala.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionExample {

	public static void main(String[] args) {
		
			Connection con = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transaction_practice", "root", "SP25@hit");
				
				con.setAutoCommit(false);
				
				//check sender balance
				String balanceQuery = "Select balance from accounts where user_id=?";
				PreparedStatement ps = con.prepareStatement(balanceQuery);
				
				ps.setString(1,  "user1");
				
				ResultSet rs = ps.executeQuery(); //Storing the result in ResultSet
				
				int balance = 0;
				
				if(rs.next()) {
					balance = rs.getInt(1);
				}
				
				int amount = 500;
				
				if(balance < amount) {
					throw new RuntimeException("Insufficient balance");
					
				}
				
				//Debit sender
				String debitQuery = "update accounts Set balance = ? where user_id = ?";
				ps = con.prepareStatement(debitQuery);
				
				ps.setInt(1,  balance - amount);
				ps.setString(2,  "user1");
				
				ps.executeUpdate();
				
				ps = con.prepareStatement(balanceQuery);
				ps.setString(1,  "user2");
				
				rs = ps.executeQuery();
				
				int receiverBalance = 0;
				
				if(rs.next()) {
					receiverBalance = rs.getInt(1);
				}
				
				ps = con.prepareStatement(debitQuery);
				
				ps.setInt(1,  receiverBalance + amount);
				ps.setString(2,  "user2");
				
				ps.executeUpdate();
				
//				String name = null;
//				name.length();
				
				//Insert transaction history
				String insertQuery = "Insert into transaction(sender,receiver, amount,status) values(?,?,?,?)";
				
				ps = con.prepareStatement(insertQuery);
				
				ps.setString(1, "user1");
				ps.setString(2, "user2");
				ps.setInt(3, amount);
				ps.setString(4, "SUCCESS");
				
				ps.executeUpdate();
				
				//commit
				con.commit();
				
				System.out.println("Transaction successful");
				}catch( Exception e) {
					try {
						if(con != null)
							con.rollback();
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					
					System.out.println("Transaction failed");
			}

	}

}
