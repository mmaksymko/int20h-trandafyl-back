package dev.trandafyl.int20htrandafylback.dto;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class CourseRequest {
    private final String name;
    private final String description;
    private final Integer credits;
    private final List<Long> groupsId;
    private final List<Long> teachersId;

}
