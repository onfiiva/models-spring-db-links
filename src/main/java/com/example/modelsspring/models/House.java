package com.example.modelsspring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "House")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(min=1, message = "Message must contain min 1 symbol")
    @NotBlank(message = "Please provide information")
    private String Type;
    @NotBlank(message = "Please provide information")
    private String Street;
    @NotNull(message = "Please provide information")
    private int Number;
    @NotBlank(message = "Please provide information")
    private String Owner;
    @NotBlank(message = "Please provide information")
    private String ConstructionDate;

    public House(int id, String type, String street, int number, String owner, String constructionDate) {
        this.id = id;
        Type = type;
        Street = street;
        Number = number;
        Owner = owner;
        ConstructionDate = constructionDate;
    }

    public House() {}

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
