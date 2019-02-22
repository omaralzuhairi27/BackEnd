package pairprogramming;

import pairprogramming.controller.PairMaker;
import pairprogramming.controller.ParticipantReader;
import pairprogramming.model.Pair;
import pairprogramming.model.Participant;
import pairprogramming.view.Screen;

import java.util.List;

public class PairProgrammingApp {

    public static void main(String[] args) {
        String filePath = "pairprogramming/file/participants.txt";
        List<Participant> participants = ParticipantReader.asList(filePath);
        List<Pair> pairs = PairMaker.make(participants);
        Screen.display(pairs);
    }

}
