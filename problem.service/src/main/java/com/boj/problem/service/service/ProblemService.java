package com.boj.problem.service.service;
import com.boj.problem.service.entity.Problem;
import com.boj.problem.service.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository problemRepository;


    public Problem createProblem(Problem problem) {
        return problemRepository.save(problem);
    }

    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }

    public Optional<Problem> getProblemById(Long id) {
        return problemRepository.findById(id);
    }

    public Problem updateProblem(Long id, Problem updatedProblem) {
        return problemRepository.findById(id).map(problem -> {
            problem.setTitle(updatedProblem.getTitle());
            problem.setStatement(updatedProblem.getStatement());
            return problemRepository.save(problem);
        }).orElseThrow(() -> new RuntimeException("Problem not found with id " + id));
    }

    public void deleteProblem(Long id) {
        problemRepository.deleteById(id);
    }
}

