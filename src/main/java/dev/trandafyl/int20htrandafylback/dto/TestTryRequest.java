package dev.trandafyl.int20htrandafylback.dto;
import lombok.Data;

import java.util.List;

@Data
public class TestTryRequest {
    private Long testId;
    private List<Answer> answers;

    @Data
    public static class Answer {
        private Long questionId;
        private Long optionId;
    }
}