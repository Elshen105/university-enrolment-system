package com.university_enrolment_system.service;

import com.university_enrolment_system.dto.request.EnrollmentRequest;
import com.university_enrolment_system.dto.response.EnrollmentResponse;

public interface EnrolmentService {
    EnrollmentResponse enrollStudent(EnrollmentRequest request);

    EnrollmentResponse getEnrollmentDetails(Long enrollmentId);
}
