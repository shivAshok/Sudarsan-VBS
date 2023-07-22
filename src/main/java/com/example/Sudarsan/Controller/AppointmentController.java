package com.example.Sudarsan.Controller;

import com.example.Sudarsan.Dtos.ResponseDto.ResponseApoointment;
import com.example.Sudarsan.Dtos.ResponseDto.ResponseCentre;
import com.example.Sudarsan.Exceptions.DoctorNtPresent;
import com.example.Sudarsan.Exceptions.PersonNotpresent;
import com.example.Sudarsan.Service.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book-appointment")
    public ResponseEntity bookAppointment(@RequestParam int personId,@RequestParam int doctorId){
       try {
           ResponseApoointment responseAppointment = appointmentService.bookAppointment(personId, doctorId);
           return new ResponseEntity<>(responseAppointment, HttpStatus.OK);
       }
       catch(PersonNotpresent ex){
           return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
       }
        catch(DoctorNtPresent ex)   {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
