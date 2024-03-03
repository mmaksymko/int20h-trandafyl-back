package dev.trandafyl.int20htrandafylback.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User{
    @ManyToMany
    @JoinTable(name = "student_groups",
            joinColumns = @JoinColumn(name = "student_id"))
    private Set<Group> groups;
}
