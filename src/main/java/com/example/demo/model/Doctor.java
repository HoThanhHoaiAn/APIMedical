package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Doctor")
public class Doctor {
    @Id
    private String id;
    private String name;
    private String urlPhoto;
    private int fee;
    private float rating;
    private String education;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId")
    private Department department;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    public Doctor() {
    }

    public Doctor(String id, String name, String urlPhoto, int fee, float rating, String education, String description) {
        this.id = id;
        this.name = name;
        this.urlPhoto = urlPhoto;
        this.fee = fee;
        this.rating = rating;
        this.education = education;
        this.description = description;
        this.schedules = new ArrayList<>();
    }

    public Doctor(String id, String name, String urlPhoto, int fee, float rating, String education, String description, Department department, List<Schedule> schedules) {
        this.id = id;
        this.name = name;
        this.urlPhoto = urlPhoto;
        this.fee = fee;
        this.rating = rating;
        this.education = education;
        this.description = description;
        this.department = department;
        this.schedules = schedules;
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

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fee=" + fee +
                ", rating=" + rating +
                ", education='" + education + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
