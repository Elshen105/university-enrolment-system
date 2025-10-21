package com.university_enrolment_system.service.impl;

import com.university_enrolment_system.dao.Repository.CourseRepository;
import com.university_enrolment_system.dao.Repository.EnrollmentRepository;
import com.university_enrolment_system.dao.Repository.StudentRepository;
import com.university_enrolment_system.dao.entity.CourseEntity;
import com.university_enrolment_system.dao.entity.EnrollmentEntity;
import com.university_enrolment_system.dao.entity.StudentEntity;
import com.university_enrolment_system.dto.request.EnrollmentRequest;
import com.university_enrolment_system.dto.response.EnrollmentResponse;
import com.university_enrolment_system.exceptions.NotFoundException;
import com.university_enrolment_system.mapper.EnrolmentMapper;
import com.university_enrolment_system.service.EnrolmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Transactional
public class EnrolmentServiceImpl implements EnrolmentService {
    CourseRepository courseRepository;
    EnrollmentRepository enrollmentRepository;
    StudentRepository studentRepository;

    @Override
    public EnrollmentResponse enrollStudent(EnrollmentRequest request) {
        log.info("📩 Yeni qeydiyyat istəyi: studentId={}, courseId={}",
                request.getStudentId(), request.getCourseId());
        StudentEntity student = studentRepository.findById(request.getStudentId()).orElseThrow(() -> new NotFoundException("student not found"));
        CourseEntity course = courseRepository.findById(request.getCourseId()).orElseThrow(() -> new NotFoundException("course not found"));

        if (course.getEnrolledCount() >= course.getCapacity()) {
            log.warn("❌ Kurs {} artıq doludur!", course.getName());
            throw new RuntimeException("Course is already full!");
        }

        EnrollmentEntity enrollment = EnrolmentMapper.ENROLMENT_MAPPER.toRequest(course, request, student);

        student.getEnrollments().add(enrollment);
        course.getEnrollments().add(enrollment);

        course.setEnrolledCount(course.getEnrolledCount() + 1);

        enrollmentRepository.save(enrollment);
        courseRepository.save(course);

        log.info("✅ {} kursuna {} adlı tələbə qeydiyyatdan keçdi.",
                course.getName(), student.getName());

        return EnrolmentMapper.ENROLMENT_MAPPER.toResponse(enrollment);
    }

    @Override
    public EnrollmentResponse getEnrollmentDetails(Long enrollmentId) {
        EnrollmentEntity enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new NotFoundException("Enrollment not found!"));

        return EnrolmentMapper.ENROLMENT_MAPPER.toResponse(enrollment);
    }
}
