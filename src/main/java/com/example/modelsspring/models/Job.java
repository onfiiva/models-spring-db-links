package com.example.modelsspring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Please provide information")
    private String Name;
    private String Type;
    @NotBlank(message = "Please provide information")
    private String Slogan;
    @Size(min=1, message = "Field must contain min 1 symbol")
    private int Employees;
    @Size(min=1, message = "Field must contain min 1 symbol")
    private int Budget;

    public Job(int id, String name, String type, String slogan, int employees, int budget) {
        this.id = id;
        Name = name;
        Type = type;
        Slogan = slogan;
        Employees = employees;
        Budget = budget;
    }

    public Job() {}

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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getSlogan() {
        return Slogan;
    }

    public void setSlogan(String slogan) {
        Slogan = slogan;
    }

    public int getEmployees() {
        return Employees;
    }

    public void setEmployees(int employees) {
        Employees = employees;
    }

    public int getBudget() {
        return Budget;
    }

    public void setBudget(int budget) {
        Budget = budget;
    }
}
