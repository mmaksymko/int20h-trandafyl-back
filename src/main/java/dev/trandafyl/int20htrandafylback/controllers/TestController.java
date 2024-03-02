package dev.trandafyl.int20htrandafylback.controllers;

import dev.trandafyl.int20htrandafylback.dto.CreateTestRequest;
import dev.trandafyl.int20htrandafylback.dto.TestResponse;
import dev.trandafyl.int20htrandafylback.dto.TestResultResponse;
import dev.trandafyl.int20htrandafylback.dto.TestTryRequest;
import dev.trandafyl.int20htrandafylback.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test/")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("{testId}/")
    public TestResponse getTest(@PathVariable Long testId) {
        return testService.getTest(testId);
    }

    @PostMapping("create/")
    public TestResponse createTest(@RequestBody CreateTestRequest request) {
        return testService.createTestAndAssignment(request);
    }

    @PutMapping("edit/{testId}/")
    public TestResponse editTest(@RequestBody CreateTestRequest request,@PathVariable Long testId) {
        return testService.editTestAndAssignment(request, testId);
    }

    @PostMapping("try/")
    public TestResultResponse tryTest(@RequestBody TestTryRequest request) {
        return testService.checkTest(request, 1L);
    }

}
