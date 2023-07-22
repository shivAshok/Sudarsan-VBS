package com.example.Sudarsan.Controller;

import com.example.Sudarsan.Dtos.ResponseDto.ResponseCertificate;
import com.example.Sudarsan.Exceptions.AppointmentNotPresent;
import com.example.Sudarsan.Service.CertificateService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RestController
@RequestMapping("/certificate")

public class CertificateController {
    @Autowired
    CertificateService certificateService;

    @GetMapping("/generate-cerificate")
    public ResponseEntity generateCertificate(@RequestParam int ap_id) throws MessagingException {
       try{
           ResponseCertificate certificate=certificateService.generateCertificate(ap_id);
           return new ResponseEntity<>(certificate, HttpStatus.OK);
       }
       catch(AppointmentNotPresent ex){
           return new ResponseEntity("Appointment doesnt exists",HttpStatus.BAD_REQUEST);
       }

    }
}
