package dev.trandafyl.int20htrandafylback.repositories;

import dev.trandafyl.int20htrandafylback.models.UniQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniQuestionsRepository extends JpaRepository<UniQuestions, Long> {
}