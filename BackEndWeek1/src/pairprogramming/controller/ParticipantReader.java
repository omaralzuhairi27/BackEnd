package pairprogramming.controller;

import CaffeeCan.Controller.FileReader;
import lombok.experimental.UtilityClass;
import pairprogramming.model.Participant;

import java.util.List;

import static java.util.stream.Collectors.toList;

@UtilityClass
public class ParticipantReader {

    public List<Participant> asList(String filePath) {
        return FileReader.lines(filePath)
                .map(line -> Participant.builder()
                        .name(line)
                        .build())
                .collect(toList());
    }

}
