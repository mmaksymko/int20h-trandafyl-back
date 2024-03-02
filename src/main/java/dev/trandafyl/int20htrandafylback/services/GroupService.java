package dev.trandafyl.int20htrandafylback.services;

import dev.trandafyl.int20htrandafylback.dto.CourseResponse;
import dev.trandafyl.int20htrandafylback.dto.GroupRequest;
import dev.trandafyl.int20htrandafylback.dto.GroupResponse;
import dev.trandafyl.int20htrandafylback.dto.StudentResponse;
import dev.trandafyl.int20htrandafylback.mappers.CourseMapper;
import dev.trandafyl.int20htrandafylback.mappers.GroupMapper;
import dev.trandafyl.int20htrandafylback.mappers.StudentMapper;
import dev.trandafyl.int20htrandafylback.models.Group;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import dev.trandafyl.int20htrandafylback.repositories.GroupRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;
    private final CourseService courseService;

    public List<GroupResponse> getAllGroups() {
        return groupRepository.findAll().stream().map(groupMapper::toResponse).toList();
    }

    public List<String> getAllGroupNames(){
        return groupRepository.findAllNames();
    }

    public List<Group> getByGroupNames(Set<String> groupNames){
        return groupRepository.findByGroupNames(groupNames);
    }

    public GroupResponse getByGroupName(String groupName) {
        var name = groupMapper.toGroupName(groupName);
        return this.getBySpecialityAndYearAndNumber(name.speciality(), name.year(), name.number());
    }

    public GroupResponse getBySpecialityAndYearAndNumber(String speciality, int year, int number) {
        return groupMapper.toResponse(groupRepository.findBySpecialityAndYearAndNumber(speciality, year, number));
    }

    public void deleteGroup(String groupName) {
        var name = groupMapper.toGroupName(groupName);
        groupRepository.deleteBySpecialityAndYearAndNumber(name.speciality(), name.year(), name.number());
    }

    public GroupResponse addGroup(GroupRequest groupRequest) {
        Group group = groupMapper.toEntity(groupRequest);

        return groupMapper.toResponse(groupRepository.save(group));
    }

    public GroupResponse updateGroup(String name, GroupRequest groupRequest) {
        Group group = groupMapper.toEntity(groupRequest);
        group.setId(getByGroupName(name).getId());

        return groupMapper.toResponse(groupRepository.save(group));
    }

    public Set<StudentResponse> getStudentsByName(String name) {
        return groupRepository.findAllStudentsByName(name).stream().map(studentMapper::toResponse).collect(Collectors.toSet());
    }

    public Set<CourseResponse> getCoursesByName(String name) {
        return groupRepository.findAllCoursesByName(name).stream().map(courseMapper::toResponse).collect(Collectors.toSet());
    }

    public CourseResponse addToCourse(String groupName, Long courseId){
        var course = courseService.getCourseById(courseId);
        var group = getByGroupName(groupName);
        group.getCourses().add(course);
        groupRepository.save(groupMapper.toEntity(group));
        return course;
    }

    public void deleteFromCourse(String groupName, Long courseId) {
        var course = courseService.getCourseById(courseId);
        var group = getByGroupName(groupName);
        group.getCourses().remove(course);
        groupRepository.save(groupMapper.toEntity(group));
    }
}
