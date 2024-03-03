package dev.trandafyl.int20htrandafylback.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "class_hours")
public class ClassHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false)
    private Integer number;

    @Basic(optional = false)
    @Column(nullable = false)
    private String startTime;

    @Basic(optional = false)
    @Column(nullable = false)
    private String endTime;

    @OneToMany(mappedBy = "classHours")
    private Set<CourseClass> courseClasses = new HashSet<>();
}