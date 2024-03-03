package dev.trandafyl.int20htrandafylback.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseRequest {
    private String name;
    private String description;
    private Integer credits;
    private List<Long> teachersIds;
}
