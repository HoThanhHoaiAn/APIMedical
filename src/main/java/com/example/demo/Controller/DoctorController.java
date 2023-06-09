package com.example.demo.Controller;

import com.example.demo.model.Doctor;
import com.example.demo.model.ResponseObject;
import com.example.demo.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;

    @GetMapping("Doctors/{departmentId}")
    public List<Doctor> getAllDoctorByDepartmentId(@PathVariable String departmentId) {
        /*
            use case 2 Đăng ký lịch khám mới
            6.2 findAllByDepartmentId(departmentId)
        */
        return repository.findAllByDepartmentId(departmentId);
    }
}
