package at.nacs.ex7streetbasketballtournament.domain;

import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
public class BasketballTeam {
    private String name;
    private List<String> players;
}
