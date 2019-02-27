package at.nacs.ex5thecalculator.controller;

import at.nacs.ex5thecalculator.model.Expression;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Expressions {

    public Expression from(String input) {
        return Stream.of(input)
                .map(e -> e.split(" "))
                .filter(e -> e.length == 3)
                .map(e -> Expression.builder()
                        .number1(Double.valueOf(e[0]))
                        .symbol(e[1])
                        .number2(Double.valueOf(e[2]))
                        .build())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);


    }
}
