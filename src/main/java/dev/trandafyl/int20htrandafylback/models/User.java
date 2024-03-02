package dev.trandafyl.int20htrandafylback.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 64)
    private String name;

    @Basic(optional = false)
    @Column(nullable = false, length = 64)
    private String surname;

    @Column(length = 64)
    private String patronymic;

    @Basic(optional = false)
    @Column(nullable = false, length = 64, unique = true)
    private String email;
}
