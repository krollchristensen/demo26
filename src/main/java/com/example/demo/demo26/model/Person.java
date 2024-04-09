package com.example.demo.demo26.model;

/**
 * Klassen repræsenterer en person med navn og alder.
 */
public class Person {
    private String name;
    private int age;

    /**
     * Konstruktør til at oprette en ny person.
     * @param name Personens navn.
     * @param age Personens alder.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters og Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
