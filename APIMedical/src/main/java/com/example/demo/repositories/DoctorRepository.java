package com.example.demo.repositories;

import com.example.demo.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {
    @Query(value = "select * from Doctor d where d.departmentId = ?1", nativeQuery = true)
    List<Doctor> findDoctorsByDepartmentId(String departmentId);
}
