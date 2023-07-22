package com.example.Sudarsan.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Table

public class Appointment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    String appointmentId;

    @CreationTimestamp
    Date appointmentDate;

    @ManyToOne
    @JoinColumn
    Doctor doctor;

    @ManyToOne
    @JoinColumn
    Person person;
}
