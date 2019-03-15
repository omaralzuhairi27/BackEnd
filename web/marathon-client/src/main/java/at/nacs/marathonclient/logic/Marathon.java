package at.nacs.marathonclient.logic;

import at.nacs.marathonclient.communication.MarathonClient;
import at.nacs.marathonclient.domain.Runner;
import at.nacs.marathonclient.domain.Summary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Marathon {

    private final List<Runner> runners;
    private final String winner;
    private final MarathonClient client;

    public Summary run() {
        sendRunners();
        return summarize();
    }

    private void sendRunners() {
        client.send(runners);
    }

    private Summary summarize() {
        Runner actualWinner = client.getWinner();
        Runner expectedWinner = getExpectedWinner();
        return Summary.builder()
                .runners(runners)
                .expectedWinner(expectedWinner)
                .actualWinner(actualWinner)
                .result(getResult(expectedWinner, actualWinner))
                .build();
    }

    private Runner getExpectedWinner() {
        return runners.stream()
                .filter(e -> e.getName().equals(winner))
                .findFirst().get();
    }

    private String getResult(Runner expectedWinner, Runner actualWinner) {
        boolean success = expectedWinner.equals(actualWinner);
        return success ? "SUCCESS" : "FAILURE";
    }

}
