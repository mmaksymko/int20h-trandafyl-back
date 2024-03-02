package dev.trandafyl.int20htrandafylback.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "uni_group",
        indexes = {
            @Index(name = "index_speciality_year_number", columnList = "speciality,year,number")
        }, uniqueConstraints = {
            @UniqueConstraint(name = "unique_speciality_year_number", columnNames = {"speciality", "year", "number"}
    )}
)
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