package com.java.prototype.pattern;

class Employee implements Cloneable {

    String name;

    Employee(String name) {
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class PrototypePattern {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e1 = new Employee("Suman");

        Employee e2 = (Employee) e1.clone();

        System.out.println(e1.name);
        System.out.println(e2.name);
	}

}
