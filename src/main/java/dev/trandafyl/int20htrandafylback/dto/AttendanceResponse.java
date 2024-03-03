package dev.trandafyl.int20htrandafylback.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceResponse {
    private String date;
    private int attendedClasses;
    private int totalClasses;
    private double attendancePercentage;
}