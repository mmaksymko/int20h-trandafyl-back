package dev.trandafyl.int20htrandafylback.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "uni_marks")
public class UniMarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false)
    private Integer mark;

    @Basic(optional = false)
    @Column(nullable = false)
    private LocalDateTime timeStamp = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "uni_assignment_id")
    private UniAssignment uniAssignment;

}