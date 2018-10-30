package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ModelCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=3)
    private String fieldsYear;

    @NotNull
    @Size(min=3)
    private String make;

    @NotNull
    @Size(min=1)
    private String model;

    public ModelCar(@NotNull @Size(min = 3) String fieldsYear, @NotNull @Size(min = 3) String make, @NotNull @Size(min = 1) String model) {
        this.fieldsYear = fieldsYear;
        this.make = make;
        this.model = model;
    }

    public ModelCar() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFieldsYear() {
        return fieldsYear;
    }

    public void setFieldsYear(String fieldsYear) {
        this.fieldsYear = fieldsYear;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
