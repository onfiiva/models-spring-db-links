package com.example.modelsspring.models;

public class Person {
    private int id;
    private String Surname;
    private String Name;
    private String Patronymic;
    private int Age;

    public Person(int id, String surname, String name, String patronymic, int age) {
        this.id = id;
        Surname = surname;
        Name = name;
        Patronymic = patronymic;
        Age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }


}
