package dev.trandafyl.int20htrandafylback.services;

import dev.trandafyl.int20htrandafylback.dto.CourseRequest;
import dev.trandafyl.int20htrandafylback.dto.CourseResponse;
import dev.trandafyl.int20htrandafylback.mappers.CourseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import dev.trandafyl.int20htrandafylback.repositories.CourseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseResponse> getAllCoursesByIds(List<Long> ids) {
        return courseRepository.findAllById(ids).stream().map(courseMapper::toResponse).toList();
    }

    public CourseResponse getCourseById(Long id) {
        return courseMapper.toResponse(courseRepository.findById(id).orElseThrow());
    }

    public CourseResponse addCourse(CourseRequest courseRequest) {
        return courseMapper.toResponse(courseRepository.save(courseMapper.toEntity(courseRequest)));
    }
}
