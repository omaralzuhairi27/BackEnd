package at.nacs.cinemamessagetemplate.configuration;

import at.nacs.cinemamessagetemplate.logic.CinemaMessageSender;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CinemaMessageSenderConfiguration {

    @Bean
    ApplicationRunner applicationRunner(CinemaMessageSender cinemaMessageSender) {
        return args -> cinemaMessageSender.sendMessages();
    }
}
