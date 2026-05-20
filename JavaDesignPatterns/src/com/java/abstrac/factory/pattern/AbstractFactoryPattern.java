package com.java.abstrac.factory.pattern;

interface Button {
    void paint();
}

class WindowsButton implements Button {

    public void paint() {
        System.out.println("Windows Button");
    }
}

class MacButton implements Button {

    public void paint() {
        System.out.println("Mac Button");
    }
}

interface GUIFactory {
    Button createButton();
}

class WindowsFactory implements GUIFactory {

    public Button createButton() {
        return new WindowsButton();
    }
}

class MacFactory implements GUIFactory {

    public Button createButton() {
        return new MacButton();
    }
}

public class AbstractFactoryPattern {

	public static void main(String[] args) {
		GUIFactory factory = new WindowsFactory();

        Button b = factory.createButton();
        b.paint();

	}

}
