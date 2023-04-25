package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeSlot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalTime start_work;
    private LocalTime end_work;
    private String work_shift;
    private int available_slot;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    @JsonBackReference
    private Schedule schedule;
    @OneToMany(mappedBy = "timeSlot", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Appointment> appointments;

    public TimeSlot(int id, LocalTime start_work, LocalTime end_work, String work_shift, int available_slot, Schedule schedule) {
        this.id = id;
        this.start_work = start_work;
        this.end_work = end_work;
        this.work_shift = work_shift;
        this.available_slot = available_slot;
        this.schedule = schedule;
    }

    public TimeSlot(int id, LocalTime start_work, LocalTime end_work, int available_slot, Schedule schedule) {
        this.id = id;
        this.start_work = start_work;
        this.end_work = end_work;
        this.available_slot = available_slot;
        this.schedule = schedule;
    }

    public TimeSlot(int id, String work_shift, int available_slot) {
        this.id = id;
        this.work_shift = work_shift;
        this.available_slot = available_slot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getStart_work() {
        return start_work;
    }

    public void setStart_work(LocalTime start_work) {
        this.start_work = start_work;
    }

    public LocalTime getEnd_work() {
        return end_work;
    }

    public void setEnd_work(LocalTime end_work) {
        this.end_work = end_work;
    }

    public String getWork_shift() {
        return work_shift;
    }

    public void setWork_shift(String work_shift) {
        this.work_shift = work_shift;
    }

    public int getAvailable_slot() {
        return available_slot;
    }

    public void setAvailable_slot(int available_slot) {
        this.available_slot = available_slot;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", start_work=" + start_work +
                ", end_work=" + end_work +
                ", work_shift='" + work_shift + '\'' +
                ", available_slot=" + available_slot +
                ", schedule=" + schedule +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlot timeSlot = (TimeSlot) o;
        return id == timeSlot.id && available_slot == timeSlot.available_slot && Objects.equals(start_work, timeSlot.start_work) && Objects.equals(end_work, timeSlot.end_work) && Objects.equals(work_shift, timeSlot.work_shift) && Objects.equals(schedule, timeSlot.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start_work, end_work, work_shift, available_slot, schedule);
    }
}
