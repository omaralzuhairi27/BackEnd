package at.nacs.rockscisserpaper.configuration;

import at.nacs.rockscisserpaper.domain.Move;
import at.nacs.rockscisserpaper.logic.Game;
import at.nacs.rockscisserpaper.logic.Judge;
import at.nacs.rockscisserpaper.logic.Moves;
import at.nacs.rockscisserpaper.ui.Host;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class GameConfiguration {
    @Bean
    Moves moves(Set <Move> moves) {
        return new Moves(moves);
    }

    @Bean
    Judge judge() {
        return new Judge();
    }

    @Bean
    Game game() {
        return new Game();
    }

    @Bean
    Host host() {
        return host();
    }
}
