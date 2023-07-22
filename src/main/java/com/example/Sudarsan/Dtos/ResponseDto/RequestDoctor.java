package com.example.Sudarsan.Dtos.ResponseDto;

import com.example.Sudarsan.Enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE )
public class RequestDoctor {
    String name;
    int age;
    String emailId;
    @Enumerated(EnumType.STRING)
    Gender gender;
    int centre_Id;
}
