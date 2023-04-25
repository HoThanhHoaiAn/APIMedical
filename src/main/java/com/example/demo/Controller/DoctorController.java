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
    @GetMapping("Doctors/{department_id}")
    public List<Doctor> getAllDoctorByDepartmentId(@PathVariable String department_id){
        return repository.findDoctorsByDepartmentId(department_id);
    }
    @GetMapping("/Doctor/{id}")
    public ResponseEntity<ResponseObject> getDoctorById(@PathVariable String id){
        Optional<Doctor> d = repository.findById(id);
        return d.isPresent()? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query doctor successfully", d)
        ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false", "Can't not find doctor with id = " + id, "")
        );
    }
}
