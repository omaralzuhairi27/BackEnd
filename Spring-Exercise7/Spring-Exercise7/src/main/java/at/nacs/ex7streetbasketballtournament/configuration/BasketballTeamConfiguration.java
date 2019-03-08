package at.nacs.ex7streetbasketballtournament.configuration;

import at.nacs.ex7streetbasketballtournament.domain.BasketballTeam;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;

@Configuration
@ConfigurationProperties("tournament")
@EnableConfigurationProperties({BasketballTeamConfiguration.class})
public class BasketballTeamConfiguration {

    @Setter
    private LinkedList <BasketballTeam> teams;

    @Bean
    LinkedList <BasketballTeam> teams() {
        return teams;
    }
}