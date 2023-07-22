package com.example.Sudarsan.Repository;

import com.example.Sudarsan.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
    @Query(value = "select * from doctor where age>:age",nativeQuery = true)
    List<Doctor> getDoctorsGreaterThanAge(int age);
}
