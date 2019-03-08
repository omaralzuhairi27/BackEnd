package at.nacs.ex7streetbasketballtournament.logic;

import at.nacs.ex7streetbasketballtournament.domain.BasketballTeam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Queue;

@Component
@AllArgsConstructor
public class Court {

    private Game game;

    public BasketballTeam getWinner(Queue <BasketballTeam> tournamentTeams) {

        while (areEnoughToPlay(tournamentTeams)) {
            game.playOneRound(tournamentTeams);
        }
//        IntStream.generate(() -> 0)
//                .takeWhile(e -> areEnoughToPlay(tournamentTeams))
//                .mapToObj(e -> game.playOneRound(tournamentTeams))
//                .forEach(tournamentTeams::offer);
        return tournamentTeams.poll();
    }

    private boolean areEnoughToPlay(Queue <BasketballTeam> teams) {
        return teams.size() > 1;
    }

}


