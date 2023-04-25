package com.example.demo.repositories;

import com.example.demo.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {
    @Query("select d from Doctor d where d.department.id=:department_id")
    List<Doctor> findByDepartmentId(@Param("department_id") String department_id);
}
