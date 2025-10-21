package com.university_enrolment_system.controller;

import com.university_enrolment_system.dto.request.EnrollmentRequest;
import com.university_enrolment_system.dto.response.EnrollmentResponse;
import com.university_enrolment_system.service.EnrolmentService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/api/v1/enrollments")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class EnrollmentController {
    EnrolmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentResponse> enrollStudent(@RequestBody EnrollmentRequest request) {
        log.info("📨 Enrollment request received: {}", request);
        EnrollmentResponse response = enrollmentService.enrollStudent(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponse> getEnrollment(@PathVariable Long id) {
        EnrollmentResponse response = enrollmentService.getEnrollmentDetails(id);
        return ResponseEntity.ok(response);
    }


}

