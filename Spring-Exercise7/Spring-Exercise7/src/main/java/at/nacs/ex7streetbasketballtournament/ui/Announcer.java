package at.nacs.ex7streetbasketballtournament.ui;

import at.nacs.ex7streetbasketballtournament.domain.BasketballTeam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Announcer {

    public void introduceTeams(List<BasketballTeam> allTeams) {
        System.out.println("-------------------------------------\n" +
                            "Welcome to the street basketball tournament!\n" +
                            "These are the teams who signed up:");
        allTeams.forEach(this::displayTeam);
        System.out.println("-------------------------------------");
    }

    private void displayTeam(BasketballTeam team) {
        String playerNamesFormatted = String.join(", ", team.getPlayers());
        System.out.println("Team: " + team.getName() + " | Players: " + playerNamesFormatted);
    }

    public void announce(BasketballTeam team1, BasketballTeam team2) {
        System.out.println(team1.getName() + " plays vs " + team2.getName());
    }

    public void announce(BasketballTeam team) {
        System.out.println("And " + team.getName() + " wins this match!");
    }

    public void announceFinalWinner(BasketballTeam team) {
        System.out.println("The tournament's winning team is " + team.getName() + " !!");
    }
}
