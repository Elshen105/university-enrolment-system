package com.university_enrolment_system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class EnrollmentResponse {
    Long id;
    String studentName;
    String studentEmail;
    String courseName;
    Integer enrolledCount;
    Integer capacity;
    LocalDateTime createdAt;
}
