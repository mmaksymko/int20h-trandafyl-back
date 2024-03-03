package dev.trandafyl.int20htrandafylback.services;

import dev.trandafyl.int20htrandafylback.dto.ScheduleStudentItemResponse;
import dev.trandafyl.int20htrandafylback.dto.ScheduleTeacherItemResponse;
import dev.trandafyl.int20htrandafylback.mappers.CourseClassMapper;
import dev.trandafyl.int20htrandafylback.models.Group;
import dev.trandafyl.int20htrandafylback.repositories.CourseClassRepository;
import dev.trandafyl.int20htrandafylback.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final CourseClassRepository courseClassRepository;
    private final GroupRepository groupRepository;
    private final CourseClassMapper courseClassMapper;

    public List<ScheduleStudentItemResponse> getScheduleForStudent(Long studentGroupId) {
        Group group = groupRepository.findById(studentGroupId).orElseThrow();
        return courseClassRepository.findByGroupsContaining(group).stream()
                .map(courseClassMapper::mapToScheduleStudentItemResponse)
                .collect(Collectors.toList());
    }

    public List<ScheduleTeacherItemResponse> getScheduleForTeacher(Long teacherId) {
        return courseClassRepository.findByTeacherId(teacherId).stream()
                .map(courseClassMapper::mapToScheduleTeacherItemResponse)
                .collect(Collectors.toList());
    }


}
