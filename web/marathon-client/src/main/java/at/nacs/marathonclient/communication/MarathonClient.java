package at.nacs.marathonclient.communication;

import at.nacs.marathonclient.domain.Runner;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MarathonClient {

    private final RestTemplate restTemplate;

    @Value("${marathon.endpoints.runners}")
    private String runnersUrl;

    @Value("${marathon.endpoints.winner}")
    private String winnerUrl;

    public void send(List<Runner> runners) {
        runners.stream()
                .forEach(runner -> restTemplate.postForObject(runnersUrl, runner, Runner.class));
    }

    public Runner getWinner() {
        return restTemplate.getForObject(winnerUrl, Runner.class);
    }

}
