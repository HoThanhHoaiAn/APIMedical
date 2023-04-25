package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date work_date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    @JsonBackReference
    private Doctor doctor;
    @OneToMany(mappedBy = "schedule",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TimeSlot> timeSlots;
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Appointment> appointments;

    public Schedule(int id, Date work_date, Doctor doctor) {
        this.id = id;
        this.work_date = work_date;
        this.doctor = doctor;
        this.timeSlots = new ArrayList<>();
    }

    public Schedule(int id, Date work_date, Doctor doctor, List<TimeSlot> timeSlots) {
        this.id = id;
        this.work_date = work_date;
        this.doctor = doctor;
        this.timeSlots = timeSlots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getWork_date() {
        return work_date;
    }

    public void setWork_date(Date work_date) {
        this.work_date = work_date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", work_date=" + work_date +
                ", doctor=" + doctor +
                ", timeSlots=" + timeSlots +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return id == schedule.id && Objects.equals(work_date, schedule.work_date) && Objects.equals(doctor, schedule.doctor) && Objects.equals(timeSlots, schedule.timeSlots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, work_date, doctor, timeSlots);
    }
}
