package at.nacs.ex7streetbasketballtournament.domain;

import lombok.Data;

import java.util.List;

@Data
public class BasketballTeam {
    private String name;
    private List <String> players;
}
