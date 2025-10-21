package com.university_enrolment_system.mapper;

import com.university_enrolment_system.dao.entity.CourseEntity;
import com.university_enrolment_system.dao.entity.EnrollmentEntity;
import com.university_enrolment_system.dao.entity.StudentEntity;
import com.university_enrolment_system.dto.request.EnrollmentRequest;
import com.university_enrolment_system.dto.response.EnrollmentResponse;

import java.time.LocalDateTime;

public enum EnrolmentMapper {
    ENROLMENT_MAPPER;

    public static EnrollmentEntity toRequest(CourseEntity course, EnrollmentRequest request, StudentEntity student) {
        return EnrollmentEntity.builder()
                .course(course)
                .student(student)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public EnrollmentResponse toResponse(EnrollmentEntity enrollment) {
        return EnrollmentResponse.builder()
                .id(enrollment.getId())
                .studentName(enrollment.getStudent().getName())
                .studentEmail(enrollment.getStudent().getEmail())
                .courseName(enrollment.getCourse().getName())
                .enrolledCount(enrollment.getCourse().getEnrolledCount())
                .capacity(enrollment.getCourse().getCapacity())
                .createdAt(enrollment.getCreatedAt())
                .build();
    }
}
