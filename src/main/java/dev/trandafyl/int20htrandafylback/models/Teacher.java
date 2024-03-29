package dev.trandafyl.int20htrandafylback.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")
public class Teacher extends User{
    @ManyToMany
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "teacher")
    private Set<CourseClass> courseClasses = new HashSet<>();

}
