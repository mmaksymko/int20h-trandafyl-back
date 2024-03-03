package dev.trandafyl.int20htrandafylback.controllers;

import dev.trandafyl.int20htrandafylback.dto.ScheduleStudentItemResponse;
import dev.trandafyl.int20htrandafylback.dto.ScheduleTeacherItemResponse;
import dev.trandafyl.int20htrandafylback.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/schedule/")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    @GetMapping("student/{studentGroupId}/")
    public List<ScheduleStudentItemResponse> getScheduleForStudent(@PathVariable Long studentGroupId) {
        return scheduleService.getScheduleForStudent(studentGroupId);
    }

    @GetMapping("/teacher/{teacherId}")
    public List<ScheduleTeacherItemResponse> getScheduleForTeacher(@PathVariable Long teacherId) {
        return scheduleService.getScheduleForTeacher(teacherId);
    }
}
