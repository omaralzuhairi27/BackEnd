package at.nacs.encoderintegrationtests.domain;

import lombok.Data;

@Data
public class Message {

    private String plaintext;
    private String ciphertext;
    
}
