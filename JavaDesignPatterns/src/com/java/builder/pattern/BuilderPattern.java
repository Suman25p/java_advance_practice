package com.java.builder.pattern;

class Student {

    private int id;
    private String name;
    private String city;

    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.city = builder.city;
    }

    public static class StudentBuilder {

        private int id;
        private String name;
        private String city;

        public StudentBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public void display() {
        System.out.println(id + " " + name + " " + city);
    }
}

public class BuilderPattern {

	public static void main(String[] args) {
		Student s = new Student.StudentBuilder()
                .setId(101)
                .setName("Suman")
                .setCity("Bihar")
                .build();

		s.display();

	}

}
