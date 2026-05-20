package com.java.creational;

class Database {

    // static object
    private static Database obj;

    // private constructor
    private Database() {
        System.out.println("Object Created");
    }

    // method to get object
    public static Database getInstance() {

        if (obj == null) {
            obj = new Database();
        }

        return obj;
    }
}

public class Singleton {
	public static void main(String[] args) {

        Database d1 = Database.getInstance();
        Database d2 = Database.getInstance();

        System.out.println(d1.hashCode());
        System.out.println(d2.hashCode());
    }
}
