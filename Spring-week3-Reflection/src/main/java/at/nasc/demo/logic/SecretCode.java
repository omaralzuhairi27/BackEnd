package at.nasc.demo.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SecretCode {

    private final Map <Integer, String> moves;

    public Set <String> getTheSecretCode(Integer number) {
        List <String> numberAsList = getStringOfNumbers(number);
        return numberAsList.stream()
                .takeWhile(e -> numberAsList.size() > 0)
                .map(e -> Integer.valueOf(e))
                .filter(e -> moves.containsKey(e))
                .map(e -> moves.get(e))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    private List <String> getStringOfNumbers(Integer number) {
        String numberAsString = String.valueOf(number);
        return Arrays.asList(numberAsString.split(""));
    }
}
