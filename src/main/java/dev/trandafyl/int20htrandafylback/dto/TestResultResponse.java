package dev.trandafyl.int20htrandafylback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestResultResponse {
    private Integer scoredMark;
    private Integer maximumMark;
    private LocalDateTime testTakenAt;
}
