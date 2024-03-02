package dev.trandafyl.int20htrandafylback.controllers;

import dev.trandafyl.int20htrandafylback.dto.StudentResponse;
import dev.trandafyl.int20htrandafylback.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students/")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("{id}/")
    public StudentResponse getStudent(@PathVariable long id) {
        return studentService.getStudent(id).orElseThrow();
    }


}
