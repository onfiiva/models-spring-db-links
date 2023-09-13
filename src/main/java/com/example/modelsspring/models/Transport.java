package com.example.modelsspring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Transport")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Please provide information")
    private String Type;
    @NotBlank(message = "Please provide information")
    private String Company;
    @NotBlank(message = "Please provide information")
    private String Model;
    @Size(min=1, message = "Field must contain min 1 symbol")
    private int Series;
    @NotBlank(message = "Please provide information")
    private String Color;

    public Transport(int id, String type, String company, String model, int series, String color) {
        this.id = id;
        Type = type;
        Company = company;
        Model = model;
        Series = series;
        Color = color;
    }

    public Transport() {}

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
