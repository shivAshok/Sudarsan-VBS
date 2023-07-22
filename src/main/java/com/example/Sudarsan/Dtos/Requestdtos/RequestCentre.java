package com.example.Sudarsan.Dtos.Requestdtos;

import com.example.Sudarsan.Enums.CentreType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class RequestCentre {
    String centreName;
    String adress;
    @Enumerated(EnumType.STRING)
    CentreType centreType;
    int centreId;
}
