package at.nacs.ex7streetbasketballtournament;

import at.nacs.ex7streetbasketballtournament.domain.BasketballTeam;
import at.nacs.ex7streetbasketballtournament.domain.BasketballTeamLoader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

@SpringBootTest
class BasketballTeamLoaderTest {

    @Autowired
    BasketballTeamLoader teamLoader;


    @Test
    void testTeams() {
        LinkedList<BasketballTeam> teams = teamLoader.getTeams();
        System.out.println(teams);
    }

}