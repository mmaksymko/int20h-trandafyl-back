package dev.trandafyl.int20htrandafylback.mappers;

import dev.trandafyl.int20htrandafylback.dto.CourseResponse;
import dev.trandafyl.int20htrandafylback.models.Course;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseMapper {

    public CourseResponse toResponse(Course course) {
        return CourseResponse
                .builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .credits(course.getCredits())
                .teachers(course.getTeachers().stream().map(teacher -> teacher.getName() + " " + teacher.getSurname()).toList())
                .build();
    }
}
