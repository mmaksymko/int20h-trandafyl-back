package dev.trandafyl.int20htrandafylback.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "uni_options")
public class UniOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 64)
    private String text;

    @Basic(optional = false)
    @Column(nullable = false)
    private Boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "uni_questions_id")
    private UniQuestions uniQuestions;

}