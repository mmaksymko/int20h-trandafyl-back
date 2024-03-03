package dev.trandafyl.int20htrandafylback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestResponse {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime deadline;
    private Integer maxMark;
    private List<QuestionResponse> questions = new ArrayList<>();

    @Data
    @Builder
    public static class QuestionResponse {
        private Long id;
        private String question;
        private List<OptionResponse> options;
        private Integer mark;
    }

    @Data
    @Builder
    public static class OptionResponse {
        private Long id;
        private String text;
    }
}