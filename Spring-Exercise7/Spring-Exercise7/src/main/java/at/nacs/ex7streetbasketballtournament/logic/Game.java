package at.nacs.ex7streetbasketballtournament.logic;

import at.nacs.ex7streetbasketballtournament.domain.BasketballTeam;
import at.nacs.ex7streetbasketballtournament.ui.Announcer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Queue;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class Game {

    private final Announcer announcer;
    private Random random = new Random();

    public void playOneRound(Queue <BasketballTeam> teams) {
        List <BasketballTeam> twoTeams = getTwoTeams(teams);
        BasketballTeam winner = getWinner(twoTeams);
        teams.offer(winner);
    }

    private List <BasketballTeam> getTwoTeams(Queue <BasketballTeam> teams) {
        BasketballTeam team1 = teams.poll();
        BasketballTeam team2 = teams.poll();
        announcer.announce(team1, team2);
        return List.of(team1, team2);
    }

    private BasketballTeam getWinner(List <BasketballTeam> twoTeams) {
        int winnerPosition = random.nextInt(2);
        BasketballTeam winner = twoTeams.get(winnerPosition);
        announcer.announce(winner);
        return winner;
    }
}
