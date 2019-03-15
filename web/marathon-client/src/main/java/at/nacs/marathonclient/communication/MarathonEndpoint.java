package at.nacs.marathonclient.communication;

import at.nacs.marathonclient.domain.Summary;
import at.nacs.marathonclient.logic.Marathon;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marathon")
@RequiredArgsConstructor
public class MarathonEndpoint {

    private final Marathon marathon;

    @GetMapping
    Summary runMarathon() {
        return marathon.run();
    }

}
