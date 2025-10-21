package com.university_enrolment_system.service;

import com.university_enrolment_system.dto.request.StudentRequest;
import com.university_enrolment_system.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse createStudent(StudentRequest request);

    StudentResponse findStudentById(Long id);
    List<StudentResponse> getAllStudents();
}
