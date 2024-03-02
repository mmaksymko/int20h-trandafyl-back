package dev.trandafyl.int20htrandafylback.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CourseResponse {
    private Long id;
    private String name;
    private String description;
    private Integer credits;
    private List<String> teachers;
}
