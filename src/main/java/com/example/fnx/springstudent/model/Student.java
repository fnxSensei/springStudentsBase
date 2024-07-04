package com.example.fnx.springstudent.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor - @NonNull над полем что бы сделать его обязательным
//@Data - содержит все аннотации перечисленные ранее + hc и equals
@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateBirth;
    @Column(unique = true) //для уникальности имаила
    private String email;
    @Transient //возрат будет генерироваться по дате рождения
    private int age;

    public int getAge() {
        return Period.between(dateBirth, LocalDate.now()).getYears();
    }
}
