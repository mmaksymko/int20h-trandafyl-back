package dev.trandafyl.int20htrandafylback.dto;

import dev.trandafyl.int20htrandafylback.models.DegreeType;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class GroupRequest {
    private String groupName;
    private DegreeType degreeType;
    private Set<Long> courses;
}
