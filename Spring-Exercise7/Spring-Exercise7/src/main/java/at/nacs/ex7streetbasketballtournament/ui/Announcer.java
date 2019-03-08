package at.nacs.ex7streetbasketballtournament.ui;

import at.nacs.ex7streetbasketballtournament.domain.BasketballTeam;
import org.springframework.stereotype.Component;

import java.util.Queue;

import static java.lang.System.out;

@Component
public class Announcer {

    public void introduceTeams(Queue <BasketballTeam> allTeams) {
        out.println("-------------------------------------\n" +
                "Welcome to the street basketball tournament!\n" +
                "These are the teams who signed up:");
        allTeams.forEach(this::displayTeam);
        out.println("-------------------------------------");
    }

    private void displayTeam(BasketballTeam team) {
        String playerNamesFormatted = String.join(", ", team.getPlayers());
        out.println("Team: " + team.getName() + " | Players: " + playerNamesFormatted);
    }

    public void announce(BasketballTeam team1, BasketballTeam team2) {
        out.println(team1.getName() + " plays vs " + team2.getName());
    }

    public void announce(BasketballTeam team) {
        out.println("And " + team.getName() + " wins this match!");
    }

    public void announceFinalWinner(BasketballTeam team) {
        out.println("The tournament's winning team is " + team.getName() + " !!");
    }
}
