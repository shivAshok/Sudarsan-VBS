package com.example.Sudarsan.Dtos.Requestdtos;

import com.example.Sudarsan.Enums.DoseType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class RequestDose {
    int personId;
    @Enumerated(EnumType.STRING)
    DoseType doseType;
}
