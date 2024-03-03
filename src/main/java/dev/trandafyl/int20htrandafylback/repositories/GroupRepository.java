package dev.trandafyl.int20htrandafylback.repositories;

import dev.trandafyl.int20htrandafylback.models.Course;
import dev.trandafyl.int20htrandafylback.models.Group;
import dev.trandafyl.int20htrandafylback.models.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("SELECT g.speciality || '-' || g.year || '' || g.number FROM Group g")
    List<String> findAllNames();
    Group findBySpecialityAndYearAndNumber(String speciality, int year, int number);

    @Query("SELECT g FROM Group g WHERE CONCAT(g.speciality, '-', g.year, '', g.number) IN (:combinations)")
    List<Group> findByGroupNames(@Param("combinations") Set<String> combinations);

    @Transactional
    @Modifying
    @Query("DELETE FROM Group g WHERE g.speciality = ?1 AND g.year = ?2 AND g.number = ?3")
    void deleteBySpecialityAndYearAndNumber(String speciality, int year, int number);

    @Query("SELECT g.students FROM Group g WHERE CONCAT(g.speciality, '-', g.year, '', g.number) = ?1")
    Set<Student> findAllStudentsByName(String groupName);

    @Query("SELECT g.courses FROM Group g WHERE CONCAT(g.speciality, '-', g.year, '', g.number) = ?1")
    Set<Course> findAllCoursesByName(String groupName);
}