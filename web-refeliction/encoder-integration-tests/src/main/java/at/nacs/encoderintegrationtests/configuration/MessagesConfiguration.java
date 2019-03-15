package at.nacs.encoderintegrationtests.configuration;

import at.nacs.encoderintegrationtests.domain.Message;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("test")
public class MessagesConfiguration {

    @Setter
    private List<Message> messages;

    @Bean
    List<Message> messages() {
        return messages;
    }
}
