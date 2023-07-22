package com.example.Sudarsan.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Table

public class Certificate {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int ceid;

    String cerificateId;
    @OneToOne
    @JoinColumn
    Person person;
}
