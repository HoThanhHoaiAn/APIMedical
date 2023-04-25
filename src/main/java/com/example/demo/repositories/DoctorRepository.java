package com.example.demo.repositories;

import com.example.demo.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {
    List<Doctor> findDoctorsByDepartment_Id(String department_id);
}
