package at.nacs.ex5thecalculator.controller;

import at.nacs.ex5thecalculator.model.Expression;
import at.nacs.ex5thecalculator.model.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
@RequiredArgsConstructor
@Component
public class Calculator {
    private final Set<Operation> operations;
    public double calculate(Expression expression) {
        return operations.stream()
                .filter(e -> e.matches(expression))
                .map(e -> e.apply(expression))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
