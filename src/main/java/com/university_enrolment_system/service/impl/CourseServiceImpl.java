package com.university_enrolment_system.service.impl;

import com.university_enrolment_system.dao.Repository.CourseRepository;
import com.university_enrolment_system.dao.entity.CourseEntity;
import com.university_enrolment_system.dto.request.CourseRequest;
import com.university_enrolment_system.dto.response.CourseResponse;
import com.university_enrolment_system.mapper.CourseMapper;
import com.university_enrolment_system.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;
    @Override
    public CourseResponse createCourse(CourseRequest request) {
        log.info("Creating new course: {}", request.getName());

        CourseEntity course = CourseMapper.COURSE_MAPPER.toEntity(request);

        CourseEntity savedCourse = courseRepository.save(course);
        log.info("Course created with id: {}", savedCourse.getId());

        return CourseMapper.COURSE_MAPPER.toResponse(savedCourse);
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(CourseMapper.COURSE_MAPPER::toResponse)
                .collect(Collectors.toList());
    }
}
