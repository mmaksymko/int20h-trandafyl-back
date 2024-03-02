package dev.trandafyl.int20htrandafylback.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 64)
    private String name;

    @Basic(optional = false)
    @Column(nullable = false)
    private String description;

    @Basic(optional = false)
    @Column(nullable = false)
    private Integer credits;

    @ManyToMany
    private Set<Teacher> teachers = new HashSet<>();

    @ManyToMany
    private Set<Group> groups = new HashSet<>();

    @ManyToMany
    private Set<UniAssignment> uniAssignments = new HashSet<>();
}
