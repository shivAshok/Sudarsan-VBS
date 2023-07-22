package com.example.Sudarsan.Dtos.ResponseDto;

import com.example.Sudarsan.Enums.DoseType;
import com.example.Sudarsan.Enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)

public class ResponseCertificate {
    String personName;
    int age;
    @Enumerated(EnumType.STRING)
    Gender gender;
    String doctorName;
    ResponseCentre centre;


    boolean dose1Taken;
    boolean dose2Taken;

    Date dose1date;
    Date dose2daten;
}
