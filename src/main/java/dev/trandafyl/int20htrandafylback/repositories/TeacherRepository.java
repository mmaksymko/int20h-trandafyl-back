package dev.trandafyl.int20htrandafylback.repositories;

import dev.trandafyl.int20htrandafylback.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<List<Teacher>> findByIdIn(List<Long> ids);
}