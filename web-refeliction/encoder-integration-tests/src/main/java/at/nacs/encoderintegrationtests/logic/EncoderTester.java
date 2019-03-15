package at.nacs.encoderintegrationtests.logic;

import at.nacs.encoderintegrationtests.communication.EncoderClient;
import at.nacs.encoderintegrationtests.domain.Message;
import at.nacs.encoderintegrationtests.domain.Summary;
import at.nacs.encoderintegrationtests.domain.TestedMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class EncoderTester {

    private final EncoderClient client;
    private final List<Message> messages;

    public Summary test() {
        List<TestedMessage> testedMessages = testMessages();
        int errors = countErrors(testedMessages);
        return Summary.builder()
                .status(errors == 0 ? "Success" : "Failure")
                .messages(testedMessages)
                .build();
    }

    private List<TestedMessage> testMessages() {
        return messages.stream()
                .map(toTestedMessage())
                .collect(toList());
    }

    private Function<Message, TestedMessage> toTestedMessage() {
        return e -> TestedMessage.builder()
                .plaintext(e.getPlaintext())
                .expected(e.getCiphertext())
                .actual(client.encode(e.getPlaintext()))
                .build();
    }

    private int countErrors(List<TestedMessage> testedMessages) {
        return testedMessages.stream()
                .mapToInt(e -> e.getExpected().equals(e.getActual()) ? 0 : 1)
                .sum();
    }

}
