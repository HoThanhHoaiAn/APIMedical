package com.example.demo.Controller;

import com.example.demo.model.Patient;
import com.example.demo.model.ResponseObject;
import com.example.demo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @GetMapping("/Patient/{id}")
    public ResponseEntity<ResponseObject> getPatientById(@PathVariable String id) {
        Optional<Patient> d = repository.findById(id);
        return d.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query doctor successfully", d)
        ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false", "Can't not find patient with id = " + id, "")
        );
    }

    @PostMapping("/savePatient")
    public ResponseEntity<Patient> addPatientDB(Patient patient) {
        try {
            Patient newPatient = repository.save(patient);
            return ResponseEntity.status(HttpStatus.OK).body(
                    newPatient);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    null);
        }
    }
}
