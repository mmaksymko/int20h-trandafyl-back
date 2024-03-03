package dev.trandafyl.int20htrandafylback.services;

import dev.trandafyl.int20htrandafylback.dto.*;
import dev.trandafyl.int20htrandafylback.mappers.UniTestMapper;
import dev.trandafyl.int20htrandafylback.models.*;
import dev.trandafyl.int20htrandafylback.repositories.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TestService {
    private final UniTestRepository testRepository;
    private final UniAssignmentRepository assignmentRepository;
    private final StudentRepository studentRepository;
    private final UniMarksRepository marksRepository;
    private final UniQuestionsRepository questionsRepository;
    private final UniOptionsRepository optionsRepository;
    private final CourseRepository courseRepository;
    private final UniTestMapper testMapper;

    public TestResponse getTest(Long testId) {
        UniTest test = testRepository.findById(testId).orElseThrow();
        return testMapper.toTestResponse(test);
    }

    @Transactional
    public TestResponse createTestAndAssignment(CreateTestRequest request) {
        UniAssignment assignment = new UniAssignment();
        assignment.setName(request.getAssignmentName());
        assignment.setDeadline(request.getDeadline());
        assignment.setMaxMark(request.getMaxMark());
        assignment.setCourse(courseRepository.findById(request.getCourseId()).orElseThrow());
        assignment = assignmentRepository.save(assignment);

        UniTest test = new UniTest();
        test.setName(request.getTestName());
        test.setUniAssignment(assignment);
        test = testRepository.save(test);

        return mapQuestions(request, test);
    }

    @Transactional
    public TestResponse editTestAndAssignment(CreateTestRequest request, Long testId) {
        UniTest test = testRepository.findById(testId).orElseThrow();
        UniAssignment assignment = test.getUniAssignment();
        assignment.setName(request.getAssignmentName());
        assignment.setDeadline(request.getDeadline());
        assignment.setMaxMark(request.getMaxMark());
        assignmentRepository.save(assignment);

        test.setName(request.getTestName());
        test.getUniQuestions().clear();
        testRepository.save(test);

        return mapQuestions(request, test);
    }

    private TestResponse mapQuestions(CreateTestRequest request, UniTest test) {
        for (CreateTestRequest.QuestionDto questionDto : request.getQuestions()) {
            UniQuestions question = new UniQuestions();
            question.setQuestion(questionDto.getQuestion());
            question.setMark(questionDto.getMark());
            question.setUniTest(test);
            question = questionsRepository.save(question);
            test.getUniQuestions().add(question);

            for (CreateTestRequest.OptionDto optionDto : questionDto.getOptions()) {
                UniOptions option = new UniOptions();
                option.setText(optionDto.getText());
                option.setIsCorrect(optionDto.getIsCorrect());
                option.setUniQuestions(question);
                optionsRepository.save(option);
                question.getUniOptions().add(option);
            }
        }

        return testMapper.toTestResponse(test);
    }

    public TestResultResponse checkTest(TestTryRequest request, Long studentId) {
        UniTest test = testRepository.findById(request.getTestId()).orElseThrow();
        Student student = studentRepository.findById(studentId).orElseThrow();

        int score = calculateScore(test, request);

        UniMarks mark = new UniMarks();
        mark.setMark(score);
        mark.setStudent(student);
        mark.setUniAssignment(test.getUniAssignment());
        marksRepository.save(mark);

        return new TestResultResponse(score,
                test.getUniAssignment().getMaxMark(), LocalDateTime.now());
    }

    private int calculateScore(UniTest test, TestTryRequest request) {
        int score = 0;
        var testList = test.getUniQuestions().stream().toList();
        for (int i = 0; i < testList.size(); i++) {
            if (testList.get(i).getCorrectAnswer().equals(request.getAnswers().get(i).getOptionId())) {
                score+=testList.get(i).getMark();
            }
        }
        return score;
    }
}
