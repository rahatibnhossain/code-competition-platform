package com.example.submission_service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    @PreAuthorize("hasRole('participant') or hasRole('admin') or hasRole('problem_setter')")
    @PostMapping
    public ResponseEntity<Submission> submitSolution(@RequestBody SubmissionRequest request) {
        return ResponseEntity.ok(submission);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Submission>> getUserSubmissions(@PathVariable String userId) {
        return ResponseEntity.ok(submissions);
    }

    @PreAuthorize("hasRole('admin') or hasRole('problem_setter')")
    @GetMapping("/problem/{problemId}")
    public ResponseEntity<List<Submission>> getProblemSubmissions(@PathVariable Long problemId) {
        return ResponseEntity.ok(submissions);
    }
}
