package com.university_enrolment_system.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = PRIVATE)
@Table(name = "course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String name;
    int capacity;
    int enrolledCount;

    @OneToMany(mappedBy = "course", cascade = ALL, orphanRemoval = true)
    @JsonIgnore
    List<EnrollmentEntity> enrollments = new ArrayList<>();

}
