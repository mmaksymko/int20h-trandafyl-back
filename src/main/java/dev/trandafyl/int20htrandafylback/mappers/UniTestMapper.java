package dev.trandafyl.int20htrandafylback.mappers;

import dev.trandafyl.int20htrandafylback.dto.TestResponse;
import dev.trandafyl.int20htrandafylback.models.UniTest;
import org.springframework.stereotype.Component;

@Component
public class UniTestMapper {

    public TestResponse toTestResponse(UniTest uniTest) {
        return TestResponse.builder()
                .id(uniTest.getId())
                .name(uniTest.getName())
                .createdAt(uniTest.getUniAssignment().getCreatedAt())
                .deadline(uniTest.getUniAssignment().getDeadline())
                .maxMark(uniTest.getUniAssignment().getMaxMark())
                .questions(uniTest.getUniQuestions().stream().map(question -> TestResponse.QuestionResponse.builder()
                        .id(question.getId())
                        .question(question.getQuestion())
                        .mark(question.getMark())
                        .options(question.getUniOptions().stream().map(option -> TestResponse.OptionResponse.builder()
                                .id(option.getId())
                                .text(option.getText())
                                .build()).toList())
                        .build()).toList())
                .build();
    }
}
