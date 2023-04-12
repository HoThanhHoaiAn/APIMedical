package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class TimeSlot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalTime start;
    private LocalTime end;
    private String work_shift;
    private int available_slot;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    @JsonBackReference
    private Schedule schedule;

    public TimeSlot(int id, LocalTime start, LocalTime end, String work_shift, int available_slot, Schedule schedule) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.work_shift = work_shift;
        this.available_slot = available_slot;
        this.schedule = schedule;
    }

    public TimeSlot(int id, LocalTime start, LocalTime end, int available_slot, Schedule schedule) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.available_slot = available_slot;
        this.schedule = schedule;
    }

    public TimeSlot(int id, String work_shift, int available_slot) {
        this.id = id;
        this.work_shift = work_shift;
        this.available_slot = available_slot;
    }

    public TimeSlot() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
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
                ", start=" + start +
                ", end=" + end +
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
        return id == timeSlot.id && available_slot == timeSlot.available_slot && Objects.equals(start, timeSlot.start) && Objects.equals(end, timeSlot.end) && Objects.equals(work_shift, timeSlot.work_shift) && Objects.equals(schedule, timeSlot.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start, end, work_shift, available_slot, schedule);
    }
}
