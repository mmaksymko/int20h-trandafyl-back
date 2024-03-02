package dev.trandafyl.int20htrandafylback.controllers;

import dev.trandafyl.int20htrandafylback.dto.CourseRequest;
import dev.trandafyl.int20htrandafylback.dto.CourseResponse;
import dev.trandafyl.int20htrandafylback.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("{id}/")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @GetMapping("groups/{groupId}/")
    public ResponseEntity<List<CourseResponse>> getCoursesByGroupId(@PathVariable Long groupId) {
        return ResponseEntity.ok(courseService.getCoursesByGroupId(groupId));
    }

    @PostMapping
    public ResponseEntity<CourseResponse> save(@RequestBody CourseRequest course) {
        return ResponseEntity.ok(courseService.save(course));
    }

}
