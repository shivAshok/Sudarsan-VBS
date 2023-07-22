package com.example.Sudarsan.Controller;

import com.example.Sudarsan.Dtos.Requestdtos.RequestDose;
import com.example.Sudarsan.Dtos.ResponseDto.ResponseDose;
import com.example.Sudarsan.Enums.DoseType;
import com.example.Sudarsan.Exceptions.PersonNotpresent;
import com.example.Sudarsan.Repository.DoseRepo;
import com.example.Sudarsan.Service.DoseService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;

    @PostMapping("take-dose-1")
    public ResponseEntity addDose(@RequestBody RequestDose requestDose){
        try {
            ResponseDose response = doseService.addDose(requestDose);
            return new ResponseEntity(response, HttpStatus.OK);
        }
       catch(PersonNotpresent ex){
           return new ResponseEntity("invalid person Id",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-all-doses")
    public List<DoseType> getAlldosesById(@RequestParam int id){
       try {
           List<DoseType> types = doseService.getAlldoses(id);
           return types;
       }
       catch(RuntimeException ex){
           return new ArrayList<>();
       }
    }

    @PostMapping("/get-dose-2")
    public ResponseEntity getDose2(@RequestBody RequestDose requestDose){
        try{
            ResponseDose dose2=doseService.getDose2(requestDose);
            return new ResponseEntity(dose2,HttpStatus.OK);
        }
        catch(PersonNotpresent ex){
            return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (RuntimeException ex){
            return new ResponseEntity("take dose 1 first",HttpStatus.FORBIDDEN);
        }
    }
}
