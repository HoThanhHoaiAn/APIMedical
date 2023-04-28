package com.example.demo.Controller;

import com.example.demo.model.Appointment;
import com.example.demo.model.ResponseObject;
import com.example.demo.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class AppointmentController {
    @Autowired
    private AppointmentRepository repository;

    @PostMapping("/saveAppointment")
    public ResponseEntity<Appointment> addDB(Appointment appointment) {
        try {
            /*
            use case 2 Đăng ký lịch khám mới
            16.1 save(appointment)
            */
            Appointment newAppointment = repository.save(appointment);
            return ResponseEntity.status(HttpStatus.OK).body(
                    newAppointment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    null);
        }
    }
}
