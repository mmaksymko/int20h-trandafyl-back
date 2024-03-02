package dev.trandafyl.int20htrandafylback.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "uni_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String speciality;

    @Basic(optional = false)
    @Column(nullable = false)
    private Integer year;

    @Basic(optional = false)
    @Column(nullable = false)
    private Integer number;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private DegreeType degreeType;

    @ManyToMany
    private Set<Course> courses = new HashSet<>();

    public String getName() {
        return speciality + "-" + year + "" + number;
    }

}