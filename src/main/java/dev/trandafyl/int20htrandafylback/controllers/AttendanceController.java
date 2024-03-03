package dev.trandafyl.int20htrandafylback.controllers;

import dev.trandafyl.int20htrandafylback.dto.AttendanceResponse;
import dev.trandafyl.int20htrandafylback.services.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/attendance/")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @GetMapping("{id}/")
    public ResponseEntity<List<AttendanceResponse>> getAttendance(@PathVariable long id, @RequestParam
                LocalDate startDate, @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(attendanceService.getAllAttendances(id, startDate, endDate));
    }


}
