package at.nacs.web;

import at.nacs.web.domain.Runner;
import at.nacs.web.domain.RunnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/runners")
@RestController
@RequiredArgsConstructor
public class RunnerEndpoint {

    private final RunnerRepository runnerRepository;

    @GetMapping
    List<Runner> getRunner() {
        return runnerRepository.findAll();
    }

    @PostMapping
    Runner add(@RequestBody Runner runner) {
        runnerRepository.addRunner(runner);
        return runner;
    }
}
