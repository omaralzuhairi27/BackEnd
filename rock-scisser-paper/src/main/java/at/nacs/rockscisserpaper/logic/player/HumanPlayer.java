package at.nacs.rockscisserpaper.logic.player;

import at.nacs.rockscisserpaper.domain.Move;
import at.nacs.rockscisserpaper.logic.Moves;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class HumanPlayer implements Player {

    private final Moves moves;
    private Scanner scanner=new Scanner(System.in);



    @Override
    public Move choose() {

        Optional<Move> move=Optional.empty();
//        return IntStream.generate(()->0)
//                .mapToObj(n->getMove())
//                .dropWhile(m->m.isEmpty())
//                .map(Optional::get)
//                .findFirst().get();
        while (move.isEmpty()){
            move=getMove();
        }

        return move.get();
    }

    private Optional <Move> getMove() {
        System.out.println("Choose your move ("+ moves.asString() +") :");
        String name = scanner.next();
        return moves.from(name);

    }

    @Override
    public boolean wantsToPlayAgin() {
        System.out.println("Do you want to play agin? yes/no ");
        String choice = scanner.nextLine();
        return Objects.equals("yes",choice);
    }
}
