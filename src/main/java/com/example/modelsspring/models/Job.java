package com.example.modelsspring.models;

public class Job {
    private int id;
    private String Name;
    private String Type;
    private String Slogan;
    private int Employees;
    private int Budget;

    public Job(int id, String name, String type, String slogan, int employees, int budget) {
        this.id = id;
        Name = name;
        Type = type;
        Slogan = slogan;
        Employees = employees;
        Budget = budget;
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
