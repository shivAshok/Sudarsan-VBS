package com.example.Sudarsan.Model;

import com.example.Sudarsan.Enums.Gender;
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
public class Doctor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    String name;

    @Column(unique = true)
    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;
    int age;

    @OneToMany(mappedBy = "doctor",cascade=CascadeType.ALL)
    List<Appointment> appointments=new ArrayList<>();

    @ManyToOne
   @JoinColumn
    VaccinationCentre centre;
}
