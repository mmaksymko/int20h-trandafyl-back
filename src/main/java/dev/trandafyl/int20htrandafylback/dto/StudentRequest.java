package dev.trandafyl.int20htrandafylback.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class StudentRequest {
    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String pfp;
    private Set<String> groupNames;
}
