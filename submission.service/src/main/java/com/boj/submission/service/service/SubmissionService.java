package com.boj.submission.service.service;

import com.boj.submission.service.entity.Submission;
import com.boj.submission.service.repository.SubmissionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {

    private final SubmissionRepository submissionRepository;

    public SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public Optional<Submission> getSubmissionById(Long id) {
        return submissionRepository.findById(id);
    }

    public Submission updateSubmission(Long id, Submission updatedSubmission) {
        return submissionRepository.findById(id)
                .map(submission -> {
                    submission.setSubmitterName(updatedSubmission.getSubmitterName());
                    submission.setResult(updatedSubmission.getResult());
                    return submissionRepository.save(submission);
                })
                .orElseThrow(() -> new RuntimeException("Submission not found with id " + id));
    }

    public void deleteSubmission(Long id) {
        submissionRepository.deleteById(id);
    }
}

