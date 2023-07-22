package com.example.Sudarsan.Repository;

import com.example.Sudarsan.Model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepo extends JpaRepository<Certificate,Integer> {
}
