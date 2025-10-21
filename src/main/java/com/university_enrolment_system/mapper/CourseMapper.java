package com.university_enrolment_system.mapper;

import com.university_enrolment_system.dao.entity.CourseEntity;
import com.university_enrolment_system.dto.request.CourseRequest;
import com.university_enrolment_system.dto.response.CourseResponse;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

public enum CourseMapper {
    COURSE_MAPPER;
    public CourseEntity toEntity(CourseRequest request) {
        return CourseEntity.builder()
                .name(request.getName())
                .capacity(request.getCapacity())
                .enrolledCount(0)
                .build();
    }

    public CourseResponse toResponse(CourseEntity course) {
        return CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .capacity(course.getCapacity())
                .enrolledCount(course.getEnrolledCount())
                .build();
    }

}
