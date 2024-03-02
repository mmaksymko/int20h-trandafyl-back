package dev.trandafyl.int20htrandafylback.services;

import dev.trandafyl.int20htrandafylback.dto.StudentRequest;
import dev.trandafyl.int20htrandafylback.dto.StudentResponse;
import dev.trandafyl.int20htrandafylback.mappers.StudentMapper;
import dev.trandafyl.int20htrandafylback.models.Student;
import dev.trandafyl.int20htrandafylback.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor

public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public Optional<StudentResponse> getStudent(long id) {
        var student = studentRepository.findById(id);
        return student.map(studentMapper::toResponse);
    }

    public Student addStudent(StudentRequest studentRequest) {
        Student student = studentMapper.toEntity(studentRequest);
        return studentRepository.save(student);
    }

    public Student editStudent(long id, StudentRequest studentRequest) {
        Student student = studentMapper.toEntity(studentRequest);
        student.setId(id);
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
}
