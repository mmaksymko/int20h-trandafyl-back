package dev.trandafyl.int20htrandafylback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleStudentItemResponse {
    private String courseName;
    private String classType;
    private String teacherName;
    private String office;
    private String startTime;
    private String endTime;
    private Integer classNumber;
    private String weekDay;
    private String weekType;
}