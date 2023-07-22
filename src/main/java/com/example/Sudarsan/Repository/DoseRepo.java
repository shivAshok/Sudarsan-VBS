package com.example.Sudarsan.Repository;

import com.example.Sudarsan.Model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepo extends JpaRepository<Dose,Integer> {
}
