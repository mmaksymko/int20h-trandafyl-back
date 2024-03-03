package dev.trandafyl.int20htrandafylback.repositories;

import dev.trandafyl.int20htrandafylback.models.CourseClass;
import dev.trandafyl.int20htrandafylback.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseClassRepository extends JpaRepository<CourseClass, Long> {
    List<CourseClass> findByGroupsContaining(Group group);
    List<CourseClass> findByTeacherId(Long teacherId);
}