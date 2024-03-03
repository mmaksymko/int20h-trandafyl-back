package dev.trandafyl.int20htrandafylback.controllers;

import dev.trandafyl.int20htrandafylback.dto.StudentRequest;
import dev.trandafyl.int20htrandafylback.dto.StudentResponse;
import dev.trandafyl.int20htrandafylback.models.Student;
import dev.trandafyl.int20htrandafylback.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students/")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("{id}/")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable long id) {
        return ResponseEntity.ok(
                studentService.getStudent(id).orElseThrow());
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody StudentRequest newStudent) {
        return ResponseEntity.ok(
                studentService.addStudent(newStudent));
    }

    @PutMapping("{id}/")
    public ResponseEntity<Student> editStudent(@PathVariable long id, @RequestBody StudentRequest studentRequest) {
        return ResponseEntity.ok(
                studentService.editStudent(id, studentRequest));
    }

    @DeleteMapping("{id}/")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }


}
