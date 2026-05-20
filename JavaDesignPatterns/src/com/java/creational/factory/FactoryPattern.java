package com.java.creational.factory;

class Car implements Vehicle {

    public void start() {
        System.out.println("Car Started");
    }
}

class Bike implements Vehicle {

    public void start() {
        System.out.println("Bike Started");
    }
}

class VehicleFactory {

    public static Vehicle getVehicle(String type) {

        if (type.equals("car")) {
            return new Car();
        }

        else if (type.equals("bike")) {
            return new Bike();
        }

        return null;
    }
}


public class FactoryPattern {

	public static void main(String[] args) {
		
		Vehicle v = VehicleFactory.getVehicle("car");
        v.start();
	}

}
