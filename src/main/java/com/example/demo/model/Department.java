package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    private String id;
    private String name;
    private String decription;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Doctor> doctors;

    public Department() {
    }

    public Department(String id, String name, String decription) {
        this.id = id;
        this.name = name;
        this.decription = decription;
        this.doctors = new ArrayList<>();
    }

    public Department(String id, String name, String decription, List<Doctor> doctors) {
        this.id = id;
        this.name = name;
        this.decription = decription;
        this.doctors = doctors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }
}

