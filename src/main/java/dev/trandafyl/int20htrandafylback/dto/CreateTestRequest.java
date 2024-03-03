package dev.trandafyl.int20htrandafylback.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateTestRequest {
    private String testName;
    private String assignmentName;
    private LocalDateTime deadline;
    private Integer maxMark;
    private List<QuestionDto> questions;
    private Long courseId;

    @Data
    public static class QuestionDto {
        private String question;
        private List<OptionDto> options;
        private Integer mark;
    }

    @Data
    public static class OptionDto {
        private String text;
        private Boolean isCorrect;
    }
}
