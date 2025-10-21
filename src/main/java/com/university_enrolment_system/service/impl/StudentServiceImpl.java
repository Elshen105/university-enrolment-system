package com.university_enrolment_system.service.impl;

import com.university_enrolment_system.dao.Repository.StudentRepository;
import com.university_enrolment_system.dao.entity.StudentEntity;
import com.university_enrolment_system.dto.request.StudentRequest;
import com.university_enrolment_system.dto.response.StudentResponse;
import com.university_enrolment_system.exceptions.NotFoundException;
import com.university_enrolment_system.mapper.StudentMapper;
import com.university_enrolment_system.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    @Override
    public StudentResponse createStudent(StudentRequest request) {
        log.info("Creating new student: {}", request.getName());

        StudentEntity student = StudentMapper.STUDENT_MAPPER.toEntity(request);
        StudentEntity savedStudent = studentRepository.save(student);

        log.info("Student created with id: {}", savedStudent.getId());

        return StudentMapper.STUDENT_MAPPER.toResponse(savedStudent);
    }

    @Override
    public StudentResponse findStudentById(Long id) {
        var foundedStudent = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student not found with id: " + id));
        return StudentMapper.STUDENT_MAPPER.toResponse(foundedStudent);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper.STUDENT_MAPPER::toResponse)
                .collect(Collectors.toList());
    }
}
