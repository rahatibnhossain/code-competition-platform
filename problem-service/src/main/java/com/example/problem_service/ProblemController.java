package com.example.problem_service;

import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/problems")
public class ProblemController {

    @GetMapping("/public")
    public ResponseEntity<List<Problem>> getPublicProblems() {
        // Public problems - no auth required
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Problem> getProblem(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }

    @PreAuthorize("hasRole('problem_setter') or hasRole('admin')")
    //Cannot resolve symbol 'PreAuthorize'
    @PostMapping
    public ResponseEntity<Problem> createProblem(@RequestBody Problem problem) {
        return ResponseEntity.ok(null);
    }
}
