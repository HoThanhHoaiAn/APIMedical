package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQuery(name = "Doctor.findDoctorsByDepartmentId",
        query = "SELECT d FROM Doctor d WHERE d.department.id = ?1")
public class Doctor implements Serializable {
    @Id
    private String id;
    private String name;
    private String url_photo;
    private int fee;
    private float rating;
    private String education;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Department department;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Schedule> schedules;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Appointment> appointments;

    public Doctor(String id, String name, String url_photo, int fee, float rating, String education, String description) {
        this.id = id;
        this.name = name;
        this.url_photo = url_photo;
        this.fee = fee;
        this.rating = rating;
        this.education = education;
        this.description = description;
        this.schedules = new ArrayList<>();
    }

    public Doctor(String id, String name, String url_photo, int fee, float rating, String education, String description, Department department, List<Schedule> schedules) {
        this.id = id;
        this.name = name;
        this.url_photo = url_photo;
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

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
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
                ", url_photo='" + url_photo + '\'' +
                ", fee=" + fee +
                ", rating=" + rating +
                ", education='" + education + '\'' +
                ", description='" + description + '\'' +
                ", department=" + department +
                ", schedules=" + schedules +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return fee == doctor.fee && Float.compare(doctor.rating, rating) == 0 && Objects.equals(id, doctor.id) && Objects.equals(name, doctor.name) && Objects.equals(url_photo, doctor.url_photo) && Objects.equals(education, doctor.education) && Objects.equals(description, doctor.description) && Objects.equals(department, doctor.department) && Objects.equals(schedules, doctor.schedules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url_photo, fee, rating, education, description, department, schedules);
    }
}
