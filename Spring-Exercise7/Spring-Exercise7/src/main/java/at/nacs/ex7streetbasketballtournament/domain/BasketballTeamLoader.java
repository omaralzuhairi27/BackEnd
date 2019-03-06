package at.nacs.ex7streetbasketballtournament.domain;

import at.nacs.ex7streetbasketballtournament.domain.BasketballTeam;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
@ConfigurationProperties("tournament")
@Setter
@Getter
public class BasketballTeamLoader {
    private  LinkedList<BasketballTeam> teams;
}
