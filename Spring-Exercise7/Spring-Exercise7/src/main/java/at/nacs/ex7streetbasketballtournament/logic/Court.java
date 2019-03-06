package at.nacs.ex7streetbasketballtournament.logic;

import at.nacs.ex7streetbasketballtournament.domain.BasketballTeam;
import at.nacs.ex7streetbasketballtournament.domain.BasketballTeamLoader;
import at.nacs.ex7streetbasketballtournament.ui.Announcer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.stream.IntStream;

@Component
@AllArgsConstructor
public class Court {

    private BasketballTeamLoader loader;
    private Game game;
    private Announcer announcer;

    public BasketballTeam getWinner() {
        LinkedList<BasketballTeam> tournamentTeams = loader.getTeams();
        announcer.introduceTeams(tournamentTeams);
        IntStream.generate(() -> 0)
                .takeWhile(e -> areEnoughToPlay(tournamentTeams))
                .mapToObj(e -> game.playOneRound(tournamentTeams))
                .forEach(tournamentTeams::offer);

//        while (areEnoughToPlay(tournamentTeams)) {
//            BasketballTeam winner = game.playOneRound(tournamentTeams);
//            tournamentTeams.offer(winner);
//        }

        BasketballTeam winnerOfTournament = tournamentTeams.poll();
        announcer.announceFinalWinner(winnerOfTournament);
        return winnerOfTournament;
    }

    private boolean areEnoughToPlay(LinkedList<BasketballTeam> teams) {
        return teams.size() > 1;
    }

}


