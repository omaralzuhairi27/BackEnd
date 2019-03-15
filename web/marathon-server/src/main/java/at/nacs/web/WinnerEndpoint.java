package at.nacs.web;

import at.nacs.web.domain.Runner;
import at.nacs.web.domain.RunnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/winner")
@RequiredArgsConstructor
public class WinnerEndpoint {

    private final RunnerRepository runnerRepository;

    @GetMapping
    public Runner getWinner() {
        return runnerRepository.findFastest().orElse(null);
    }
}
