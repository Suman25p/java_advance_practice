package com.kodewala.jdbc.transaction;

public class Driver {

	public static void main(String[] args) {
		
		FundTransfer ft = new FundTransfer();
		try {
		ft.doFundTransfer("user1", "user2", 100);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
//Amount100, has been deducted from user user1
//Amount100, has been credited to user user2