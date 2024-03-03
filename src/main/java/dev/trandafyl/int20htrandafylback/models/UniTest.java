package dev.trandafyl.int20htrandafylback.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "uni_test")
@Data
public class UniTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 64)
    private String name;

    @OneToOne
    private UniAssignment uniAssignment;

    @OneToMany(mappedBy = "uniTest")
    private Set<UniQuestions> uniQuestions = new HashSet<>();

}
