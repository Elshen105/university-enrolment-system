package com.university_enrolment_system.controller;

import com.university_enrolment_system.dto.request.CourseRequest;
import com.university_enrolment_system.dto.response.CourseResponse;
import com.university_enrolment_system.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class CourseController {

    CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponse> createCourse(@RequestBody CourseRequest request) {
        log.info("Received request to create course: {}", request.getName());
        CourseResponse response = courseService.createCourse(request);
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        List<CourseResponse> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }
}
