package at.nacs.rockscisserpaper.configuration;

import at.nacs.rockscisserpaper.domain.Move;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MoveConfiguration {

    @Bean
    Move rock() {
        return new Move("rock", "scissors");
    }

    @Bean
    Move scissors() {
        return new Move("scissors", "paper");
    }

    @Bean
    Move paper() {
        return new Move("paper", "rock");
    }
}
