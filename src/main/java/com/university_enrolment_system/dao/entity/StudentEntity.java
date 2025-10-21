package com.university_enrolment_system.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.PRIVATE;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String name;
    String email;

    @OneToMany(mappedBy = "student", cascade = ALL, orphanRemoval = true)
    @JsonIgnore
    List<EnrollmentEntity> enrollments = new ArrayList<>();
}
