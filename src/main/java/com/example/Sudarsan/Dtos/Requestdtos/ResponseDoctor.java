package com.example.Sudarsan.Dtos.Requestdtos;

import com.example.Sudarsan.Dtos.ResponseDto.ResponseCentre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE )

public class ResponseDoctor {
    String dtname;
    String msg;
    ResponseCentre response;
}
