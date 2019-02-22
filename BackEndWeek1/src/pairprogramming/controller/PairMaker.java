package pairprogramming.controller;

import lombok.experimental.UtilityClass;
import pairprogramming.model.Pair;
import pairprogramming.model.Participant;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@UtilityClass
public class PairMaker {

    public List<Pair> make(List<Participant> participants) {
        if (participants.size() < 2) {
            return new ArrayList<>();
        }
        Queue<Participant> shuffled = shuffle(participants);
        List<Pair> pairs = toPairs(shuffled);
        addLastParticipant(pairs, shuffled);
        return pairs;
    }

    private Queue<Participant> shuffle(List<Participant> participants) {
        List<Participant> shuffled = new LinkedList<>(participants);
        Collections.shuffle(shuffled);
        return (Queue<Participant>) shuffled;
    }

    private List<Pair> toPairs(Queue<Participant> participants) {
        return IntStream.generate(() -> 0)
                .takeWhile(n -> participants.size() > 1)
                .mapToObj(n1 -> Pair.builder()
                        .participants(Stream.of(participants.poll(), participants.poll())
                                .collect(toList()))
                        .build())
                .collect(toList());
    }


    private void addLastParticipant(List<Pair> pairs, Queue<Participant> participants) {
        if (participants.isEmpty()) {
            return;
        }
        Pair firstPair = pairs.get(0);
        Participant lastParticipant = participants.poll();
        firstPair.getParticipants().add(lastParticipant);
    }

}
