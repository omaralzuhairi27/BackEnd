package pairprogramming.view;

import lombok.experimental.UtilityClass;
import pairprogramming.model.Pair;
import pairprogramming.model.Participant;

import java.util.List;

import static java.util.stream.Collectors.joining;

@UtilityClass
public class Screen {

    public void display(List<Pair> pairs) {
        System.out.println("\n------- PAIRS -------\n");
        pairs.forEach(pair -> {
            String names = pair.getParticipants().stream()
                    .map(Participant::getName)
                    .collect(joining(", "));
            System.out.println(names);
        });
        System.out.println("\n------- PAIRS -------");
    }


}
