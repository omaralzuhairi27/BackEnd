package at.nacs.rockscisserpaper.configuration;

import at.nacs.rockscisserpaper.domain.Move;
import at.nacs.rockscisserpaper.logic.Moves;
import at.nacs.rockscisserpaper.logic.player.ComputerPlayer;
import at.nacs.rockscisserpaper.logic.player.HumanPlayer;
import at.nacs.rockscisserpaper.logic.player.Player;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfiguration {
    @Bean
    Player human(Moves moves) {
        return new HumanPlayer(moves);
    }

    @Bean
    Player computer(List <Move> moves) {
        return new ComputerPlayer(moves);
    }


}
