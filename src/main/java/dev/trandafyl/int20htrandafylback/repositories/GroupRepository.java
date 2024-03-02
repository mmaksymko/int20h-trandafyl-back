package dev.trandafyl.int20htrandafylback.repositories;

import dev.trandafyl.int20htrandafylback.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("SELECT g.speciality || '-' || g.year || '' || g.number FROM Group g")
    List<String> findAllNames();
    Group findBySpecialityAndYearAndNumber(String speciality, int year, int number);

    @Query("SELECT g FROM Group g WHERE CONCAT(g.speciality, '-', g.year, '', g.number) IN (:combinations)")
    List<Group> findByGroupNames(@Param("combinations") Set<String> combinations);
}
