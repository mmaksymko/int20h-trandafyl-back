package dev.trandafyl.int20htrandafylback.mappers;


import dev.trandafyl.int20htrandafylback.dto.StudentRequest;
import dev.trandafyl.int20htrandafylback.dto.StudentResponse;
import dev.trandafyl.int20htrandafylback.models.Student;
import dev.trandafyl.int20htrandafylback.repositories.GroupRepository;
import dev.trandafyl.int20htrandafylback.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;


@Component
//@AllArgsConstructor
public class StudentMapper {
    private final GroupMapper groupMapper;
    private final GroupService groupService;
    @Value("${user.default.pfp.link}")
    private String defaultPfp;
    @Autowired
    GroupRepository groupRepository;

    public StudentMapper(GroupMapper groupMapper, GroupService groupService) {
        this.groupMapper = groupMapper;
        this.groupService = groupService;
    }

    public StudentResponse toResponse(Student student) {
        return StudentResponse
                .builder()
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .patronymic(student.getPatronymic())
                .email(student.getEmail())
                .groups(student.getGroups().stream().map(groupMapper::toResponse).collect(Collectors.toSet()))
                .build();
    }

    public Student toEntity(StudentRequest studentRequest) {
        return Student
                .builder()
                .groups(new HashSet<>(groupService.getByGroupNames(studentRequest.getGroupNames())))
                .name(studentRequest.getName())
                .surname(studentRequest.getSurname())
                .patronymic(studentRequest.getPatronymic())
                .email(studentRequest.getEmail())
//                .pfp(studentRequest.getPfp() != null ? studentRequest.getPfp() : defaultPfp)
                .build();
    }
}
