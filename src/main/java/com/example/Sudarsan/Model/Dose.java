package com.example.Sudarsan.Model;

import com.example.Sudarsan.Enums.DoseType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Table
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int d_id;

    String doseId;

    @Enumerated(value = EnumType.STRING)
    DoseType doseType;

    @CreationTimestamp
    Date vaccinationDate;

    @ManyToOne
    @JoinColumn
    Person person;
}
