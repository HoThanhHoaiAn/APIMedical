package com.example.demo.Controller;

import com.example.demo.model.Department;
import com.example.demo.model.ResponseObject;
import com.example.demo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class DepartmentController {
    @Autowired
    private DepartmentRepository repository;
    @GetMapping("/Departments")
    public List<Department> getAll(){
        /*
            use case 2 Đăng ký lịch khám mới
           4.2 findAll()
        */
        return repository.findAll();
    }
}
