package com.example.demo.repositories;

import com.example.demo.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {
    @Query(name = "Doctor.findDoctorsByDepartmentId")
    List<Doctor> findDoctorsByDepartmentId(String department_id);
}
