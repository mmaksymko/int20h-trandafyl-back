package dev.trandafyl.int20htrandafylback.mappers;


import dev.trandafyl.int20htrandafylback.dto.StudentRequest;
import dev.trandafyl.int20htrandafylback.dto.StudentResponse;
import dev.trandafyl.int20htrandafylback.models.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class StudentMapper {
    private final GroupMapper groupMapper;

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

    public Student toModel(StudentRequest studentResponse) {
        return null;
    }
}
