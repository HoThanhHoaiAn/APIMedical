package com.example.demo.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Schedule {
    @Id
    private String id;
    @Temporal(TemporalType.DATE)
    private Date workDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctorId")
    private Doctor doctor;
    public Schedule() {
    }

    public Schedule(String id, Date workDate, Doctor doctor) {
        this.id = id;
        this.workDate = workDate;
        this.doctor = doctor;
    }
}
