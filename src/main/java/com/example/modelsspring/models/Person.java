package com.example.modelsspring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Please provide information")
    private String Surname;
    @NotBlank(message = "Please provide information")
    private String Name;
    @NotBlank(message = "Please provide information")
    private String Patronymic;
    @Size(min=1, message = "Field must contain min 1 symbol")
    private int Age;

    public Person(int id, String surname, String name, String patronymic, int age) {
        this.id = id;
        Surname = surname;
        Name = name;
        Patronymic = patronymic;
        Age = age;
    }

    public Person() {}

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
