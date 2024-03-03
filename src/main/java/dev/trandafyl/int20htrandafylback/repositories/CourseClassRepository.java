package dev.trandafyl.int20htrandafylback.repositories;

import dev.trandafyl.int20htrandafylback.models.CourseClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CourseClassRepository extends JpaRepository<CourseClass, Long> {
    Set<Long> findGroupIdsByStudentId(Long studentId);
}