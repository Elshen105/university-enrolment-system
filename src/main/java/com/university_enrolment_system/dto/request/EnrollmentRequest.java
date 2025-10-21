package com.university_enrolment_system.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class EnrollmentRequest {
    Long studentId;
    Long courseId;
}
