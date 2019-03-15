package at.nacs.encoderintegrationtests.communication;

import at.nacs.encoderintegrationtests.domain.Summary;
import at.nacs.encoderintegrationtests.logic.EncoderTester;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/integrationtest")
@RequiredArgsConstructor
public class IntegrationTestEndpoint {

    private final EncoderTester encoderTester;

    @GetMapping
    Summary test() {
        return encoderTester.test();
    }
    
}
