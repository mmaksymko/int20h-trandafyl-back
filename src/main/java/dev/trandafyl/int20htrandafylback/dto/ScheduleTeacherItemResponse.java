package dev.trandafyl.int20htrandafylback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleTeacherItemResponse {
    private String courseName;
    private String classType;
    private List<String> groups;
    private String office;
    private String startTime;
    private String endTime;
    private Integer classNumber;
    private String weekDay;
    private String weekType;
}