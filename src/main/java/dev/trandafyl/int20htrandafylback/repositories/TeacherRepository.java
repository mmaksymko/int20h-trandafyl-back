package dev.trandafyl.int20htrandafylback.repositories;

import dev.trandafyl.int20htrandafylback.models.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Set<Teacher> findByIdIn(List<Long> ids);
}
