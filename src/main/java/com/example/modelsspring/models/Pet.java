package com.example.modelsspring.models;

public class Pet {
    private int id;
    private String Name;
    private String Breed;
    private String Type;
    private int Age;
    private String Gender;

    public Pet(int id, String name, String breed, String type, int age, String gender) {
        this.id = id;
        Name = name;
        Breed = breed;
        Type = type;
        Age = age;
        Gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
