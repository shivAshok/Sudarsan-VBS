package com.example.Sudarsan.Dtos.Requestdtos;

import com.example.Sudarsan.Enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)



public class AddpersonDto {
    String name;
    int age;
    String emailId;
    @Enumerated(EnumType.STRING)
    Gender gender;
}
