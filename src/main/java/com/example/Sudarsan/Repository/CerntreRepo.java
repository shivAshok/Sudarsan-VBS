package com.example.Sudarsan.Repository;

import com.example.Sudarsan.Model.VaccinationCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CerntreRepo extends JpaRepository<VaccinationCentre,Integer> {
}
