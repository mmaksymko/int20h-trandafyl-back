package dev.trandafyl.int20htrandafylback.services;

import dev.trandafyl.int20htrandafylback.dto.CourseRequest;
import dev.trandafyl.int20htrandafylback.dto.CourseResponse;
import dev.trandafyl.int20htrandafylback.mappers.CourseMapper;
import dev.trandafyl.int20htrandafylback.models.Course;
import dev.trandafyl.int20htrandafylback.repositories.CourseRepository;
import dev.trandafyl.int20htrandafylback.repositories.GroupRepository;
import dev.trandafyl.int20htrandafylback.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import dev.trandafyl.int20htrandafylback.repositories.CourseRepository;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final GroupRepository groupRepository;
    private final CourseMapper courseMapper;

    public List<CourseResponse> getAllCoursesByIds(List<Long> ids) {
        return courseRepository.findAllById(ids).stream().map(courseMapper::toResponse).toList();


    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll().stream().map(courseMapper::toResponse).collect(Collectors.toList());
    }

    public CourseResponse getCourseById(Long id) {
        return courseMapper.toResponse(courseRepository.findById(id).orElseThrow());
    }

    public CourseResponse addCourse(CourseRequest courseRequest) {
        var course = courseMapper.toEntity(courseRequest);
        course.getTeachers().forEach(teacher -> teacher.getCourses().add(course));
        return courseMapper.toResponse(courseRepository.save(course));
    }

     public List<CourseResponse> getCoursesByGroupId(Long groupId) {
        return courseRepository.
                findByGroupsId(groupId).orElseThrow().stream().map(courseMapper::toResponse).collect(Collectors.toList());
    }

    public CourseResponse save(CourseRequest course) {
        List<Long> teacherIds = course.getTeachersId();
        List<Long> groupIds = course.getGroupsId();
        Course courseEntity = courseMapper.toEntity(course);
        courseEntity.setTeachers(new HashSet<>(teacherRepository.findByIdIn(teacherIds).orElseThrow()));
        courseEntity.setGroups(new HashSet<>(groupRepository.findByIdIn(groupIds).orElseThrow()));
        return courseMapper.toResponse(courseRepository.save(courseEntity));
    }
}
