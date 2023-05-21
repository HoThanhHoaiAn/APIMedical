package com.example.demo;

import com.example.demo.model.Appointment;
import com.example.demo.model.Patient;
import com.example.demo.repositories.AppointmentRepository;
import com.example.demo.repositories.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    private PatientRepository repository;
    @Autowired
    private AppointmentRepository repositoryA;

    @org.junit.Test
    public void testSave() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse("2002-12-14");
        Patient patient = new Patient("4", "0978080435", "An", date, 1, "asdasd", "asdasd", "asd", "asdasd");
        Patient s = repository.save(patient);
        Appointment a = new Appointment();
        a.setStatus(1);
        a.setPatient(patient);
        a.setDoctor(null);
        a.setDescription("benh");
        a.setSchedule(null);
        a.setTimeSlot(null);
        Appointment b = repositoryA.save(a);
        Assertions.assertNotNull(s);
        Assertions.assertNotNull(b);
    }

}
