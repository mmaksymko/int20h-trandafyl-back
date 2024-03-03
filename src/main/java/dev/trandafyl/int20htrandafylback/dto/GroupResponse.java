package dev.trandafyl.int20htrandafylback.dto;

import dev.trandafyl.int20htrandafylback.models.DegreeType;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class GroupResponse{
    private Long id;
    private String speciality;
    private Integer year;
    private Integer number;
    private DegreeType degreeType;
    private Set<CourseResponse> courses;
    private String name;

    private String getName() {
        return speciality + "-" + year + "" + number;
    }
}
