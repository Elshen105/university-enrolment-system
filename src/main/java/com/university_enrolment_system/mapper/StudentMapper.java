package com.university_enrolment_system.mapper;

import com.university_enrolment_system.dao.entity.StudentEntity;
import com.university_enrolment_system.dto.request.StudentRequest;
import com.university_enrolment_system.dto.response.StudentResponse;

import java.util.stream.Collectors;

public enum StudentMapper {
    STUDENT_MAPPER;
    public StudentEntity toEntity(StudentRequest request) {
        return StudentEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();
    }

    public StudentResponse toResponse(StudentEntity studentEntity) {
        return StudentResponse.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .email(studentEntity.getEmail())
                .build();
    }

}
