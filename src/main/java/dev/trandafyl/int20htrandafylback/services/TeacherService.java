package dev.trandafyl.int20htrandafylback.services;

import dev.trandafyl.int20htrandafylback.models.Teacher;
import dev.trandafyl.int20htrandafylback.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    public Set<Teacher> getTeachersByIds(List<Long> ids){
        return teacherRepository.findByIdIn(ids);
    }
}
