package com.example.Sudarsan.Controller;

import com.example.Sudarsan.Dtos.Requestdtos.ResponseDoctor;
import com.example.Sudarsan.Dtos.ResponseDto.RequestDoctor;
import com.example.Sudarsan.Service.DoctorService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RestController
@RequestMapping("/Doctor")

public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add-doctor")
    public ResponseEntity addDoctor(@RequestBody RequestDoctor requestDoctor){
       try{
           ResponseDoctor response=doctorService.addDoctor(requestDoctor);
           return new ResponseEntity(response, HttpStatus.OK);
       }
        catch(RuntimeException ex)   {
            return new ResponseEntity("invalid centre id", HttpStatus.OK);
        }

    }
}
