package at.nacs.ex7streetbasketballtournament.logic;

import at.nacs.ex7streetbasketballtournament.domain.BasketballTeam;
import at.nacs.ex7streetbasketballtournament.ui.Announcer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class Game {

    private Random random = new Random();
    private final Announcer announcer;

    public BasketballTeam playOneRound(LinkedList<BasketballTeam> teams) {
        List<BasketballTeam> twoTeams = getTwoTeams(teams);
        return getWinnerOfGame(twoTeams);
    }

    private List<BasketballTeam> getTwoTeams(LinkedList<BasketballTeam> teams) {
        BasketballTeam team1 = teams.poll();
        BasketballTeam team2 = teams.poll();
        announcer.announce(team2, team2);
        return List.of(team1, team2);
    }

    private BasketballTeam getWinnerOfGame(List<BasketballTeam> twoTeams) {
        int winnerPosition = random.nextInt(2);
        BasketballTeam winner = twoTeams.get(winnerPosition);
        announcer.announce(winner);
        return winner;
    }
}
