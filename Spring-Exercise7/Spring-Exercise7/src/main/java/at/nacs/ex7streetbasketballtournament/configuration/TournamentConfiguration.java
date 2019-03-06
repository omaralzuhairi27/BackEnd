package at.nacs.ex7streetbasketballtournament.configuration;

import at.nacs.ex7streetbasketballtournament.logic.Court;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TournamentConfiguration {



    @Bean
    ApplicationRunner applicationRunner(Court court){

        return args ->  court.getWinner();
    }




}
