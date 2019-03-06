package at.nacs.rockscisserpaper.logic.player;

import at.nacs.rockscisserpaper.domain.Move;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;
import java.util.Set;

@RequiredArgsConstructor
public class ComputerPlayer implements Player {

    private final List<Move> moves;
    private Random random = new Random();

    @Override
    public Move choose() {
        int numberOfMoves= moves.size();
        int position=random.nextInt(numberOfMoves);
        return moves.get(position);
    }

    @Override
    public boolean wantsToPlayAgin() {
        return true;
    }
}
