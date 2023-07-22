package com.example.Sudarsan.Repository;

import com.example.Sudarsan.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApointmentRepo extends JpaRepository<Appointment,Integer> {

}
