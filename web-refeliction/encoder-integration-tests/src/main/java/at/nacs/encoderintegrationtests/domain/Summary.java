package at.nacs.encoderintegrationtests.domain;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Summary {

    private String status;
    private List<TestedMessage> messages;

}
