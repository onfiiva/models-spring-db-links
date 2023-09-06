package com.example.modelsspring.models;

public class Transport {
    private int id;
    private String Type;
    private String Company;
    private String Model;
    private int Series;
    private String Color;

    public Transport(int id, String type, String company, String model, int series, String color) {
        this.id = id;
        Type = type;
        Company = company;
        Model = model;
        Series = series;
        Color = color;
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

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getSeries() {
        return Series;
    }

    public void setSeries(int series) {
        Series = series;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
