package dev.trandafyl.int20htrandafylback.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "uni_assignment")
public class UniAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 64)
    private String name;

    @Basic(optional = false)
    @Column(nullable = false)
    private final LocalDateTime createdAt = LocalDateTime.now();

    @Basic(optional = false)
    @Column(nullable = false)
    private LocalDateTime deadline;

    @Basic(optional = false)
    @Column(nullable = false)
    private Integer maxMark;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "uniAssignment")
    private Set<UniMarks> uniMarks = new HashSet<>();
}