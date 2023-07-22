package com.example.Sudarsan.Dtos.ResponseDto;

import com.example.Sudarsan.Enums.DoseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseDose {
    String doseId;

    DoseType doseType;


    Date date;

    PersonResponse personResponse;
}
