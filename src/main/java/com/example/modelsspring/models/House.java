package com.example.modelsspring.models;

public class House {
    private int id;
    private String Type;
    private String Street;
    private int Number;
    private String Owner;
    private String ConstructionDate;

    public House(int id, String type, String street, int number, String owner, String constructionDate) {
        this.id = id;
        Type = type;
        Street = street;
        Number = number;
        Owner = owner;
        ConstructionDate = constructionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getConstructionDate() {
        return ConstructionDate;
    }

    public void setConstructionDate(String constructionDate) {
        ConstructionDate = constructionDate;
    }
}
