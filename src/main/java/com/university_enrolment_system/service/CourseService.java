package com.university_enrolment_system.service;

import com.university_enrolment_system.dto.request.CourseRequest;
import com.university_enrolment_system.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {
    CourseResponse createCourse(CourseRequest request);

    List<CourseResponse> getAllCourses();
}
