package dev.trandafyl.int20htrandafylback.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "uni_questions")
public class UniQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 64)
    private String question;

    @Basic(optional = false)
    @Column(nullable = false)
    private Integer mark;

    @OneToMany(mappedBy = "uniQuestions")
    private Set<UniOptions> uniOptions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "uni_test_id")
    private UniTest uniTest;

    public Long getCorrectAnswer(){
        for (UniOptions option : uniOptions) {
            if (option.getIsCorrect()) {
                return option.getId();
            }
        }
        return null;
    }

}