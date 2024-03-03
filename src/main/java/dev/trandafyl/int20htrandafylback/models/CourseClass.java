package dev.trandafyl.int20htrandafylback.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course_class")
@Data
public class CourseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false)
    private String name;

    @Basic(optional = false)
    @Column(nullable = false)
    private String office;

    @ManyToMany
    private Set<Group> groups = new HashSet<>();

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Course course;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private WeekType weekType;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private ClassType classType;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private WeekDay weekDay;

    @ManyToOne
    @JoinColumn(name = "class_hours_id")
    private ClassHours classHours;

    public ClassHours getClassHours() {
        return classHours;
    }

}
