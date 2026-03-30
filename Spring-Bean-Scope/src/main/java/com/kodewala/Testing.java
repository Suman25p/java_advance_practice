package com.kodewala;
//object life cycle
public class Testing {
	
	int amount;
	{
		System.out.println("pre init"); //1
	}
	public Testing(int _amount)
	{
		System.out.println("init"); //2
		this.amount = _amount;
	}
	
	public static void main(String[] args) {
		
		Testing testing = new Testing(200);
		
		//using Object
		testing.sayHello(); //3
		testing = null; //cleanup / destroy 

	}
	
	public void sayHello()
	{
		System.out.println("testing.sayHello()"); 
	}

}
