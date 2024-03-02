package dev.trandafyl.int20htrandafylback.mappers;

import dev.trandafyl.int20htrandafylback.dto.GroupResponse;
import dev.trandafyl.int20htrandafylback.models.Group;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GroupMapper {
    private final CourseMapper courseMapper;

    public GroupResponse toResponse(Group group) {
        return
                GroupResponse.builder()
                .id(group.getId())
                .name(group.getName())
                .courses(group.getCourses().stream().map(courseMapper::toResponse).collect(Collectors.toSet()))
                .build();
    }

    public Group toEntity(GroupResponse groupResponse) {
        return null;
    }
}
