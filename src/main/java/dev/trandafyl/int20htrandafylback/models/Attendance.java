package dev.trandafyl.int20htrandafylback.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_class_id", nullable = false)
    private CourseClass courseClass;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Boolean attended;
}
