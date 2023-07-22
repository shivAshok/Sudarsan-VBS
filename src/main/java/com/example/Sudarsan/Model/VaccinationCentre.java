package com.example.Sudarsan.Model;

import com.example.Sudarsan.Enums.CentreType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Table

public class VaccinationCentre {
   @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    int id;

   String centreName;
   @Enumerated(EnumType.STRING)
    CentreType centreType;

   String adress;

   @OneToMany(mappedBy="centre",cascade = CascadeType.ALL)
    List<Doctor> doctors=new ArrayList<>();

}
