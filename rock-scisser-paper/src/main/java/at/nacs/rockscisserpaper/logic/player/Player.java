package at.nacs.rockscisserpaper.logic.player;


import at.nacs.rockscisserpaper.domain.Move;

public interface Player {

    Move choose();
    boolean wantsToPlayAgin();
}
