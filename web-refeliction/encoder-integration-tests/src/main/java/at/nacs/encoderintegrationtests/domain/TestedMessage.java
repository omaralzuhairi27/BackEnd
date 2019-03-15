package at.nacs.encoderintegrationtests.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TestedMessage {

    private String plaintext;
    private String expected;
    private String actual;

}
