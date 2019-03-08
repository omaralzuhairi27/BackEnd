package at.nacs.ex7streetbasketballtournament.logic;

import at.nacs.ex7streetbasketballtournament.domain.BasketballTeam;
import at.nacs.ex7streetbasketballtournament.ui.Announcer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Queue;

@Component
@RequiredArgsConstructor
public class Tournament {

    private final Queue <BasketballTeam> teams;
    private final Court court;
    private final Announcer announcer;

    public void start() {
        announcer.introduceTeams(teams);
        BasketballTeam winner = court.getWinner(teams);
        announcer.announceFinalWinner(winner);
    }
}
