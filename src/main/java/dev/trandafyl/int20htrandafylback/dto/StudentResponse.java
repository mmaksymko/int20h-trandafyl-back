package dev.trandafyl.int20htrandafylback.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class StudentResponse {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private Set<GroupResponse> groups;
}
