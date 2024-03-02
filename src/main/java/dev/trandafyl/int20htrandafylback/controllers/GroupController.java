package dev.trandafyl.int20htrandafylback.controllers;

import dev.trandafyl.int20htrandafylback.dto.CourseResponse;
import dev.trandafyl.int20htrandafylback.dto.GroupRequest;
import dev.trandafyl.int20htrandafylback.dto.GroupResponse;
import dev.trandafyl.int20htrandafylback.dto.StudentResponse;
import dev.trandafyl.int20htrandafylback.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/groups/")
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public ResponseEntity<List<GroupResponse>> getGroups() {
        var groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups);
    }

    @GetMapping("{name}/")
    public ResponseEntity<GroupResponse> getGroup(@PathVariable String name) {
        var group = groupService.getByGroupName(name);
        return ResponseEntity.ok(group);
    }

    @PostMapping
    public ResponseEntity<GroupResponse> addGroup(@RequestBody GroupRequest group) {
        GroupResponse newGroup = groupService.addGroup(group);
        return ResponseEntity.ok(newGroup);
    }

    @PostMapping("{name}/")
    public ResponseEntity<GroupResponse> editGroup(@PathVariable String name, @RequestBody GroupRequest group) {
        GroupResponse newGroup = groupService.updateGroup(name, group);
        return ResponseEntity.ok(newGroup);
    }

    @DeleteMapping("{name}/")
    public void deleteGroup(@PathVariable String name) {
        groupService.deleteGroup(name);
    }

    @GetMapping("{name}/students/")
    public ResponseEntity<Set<StudentResponse>> getStudents(@PathVariable String name) {
        return ResponseEntity.ok(groupService.getStudentsByName(name));
    }

    @GetMapping("{name}/courses/")
    public ResponseEntity<Set<CourseResponse>> getCourses(@PathVariable String name) {
        return ResponseEntity.ok(groupService.getCoursesByName(name));
    }

    @PostMapping("{name}/courses/{courseId}/")
    public void addStudent(@PathVariable String name, @RequestBody Long courseId) {
        groupService.addToCourse(name, courseId);
    }

    @DeleteMapping("{name}/courses/{courseId}/")
    public void deleteCourse(@PathVariable String name, @PathVariable Long courseId) {
        groupService.deleteFromCourse(name, courseId);
    }
}
