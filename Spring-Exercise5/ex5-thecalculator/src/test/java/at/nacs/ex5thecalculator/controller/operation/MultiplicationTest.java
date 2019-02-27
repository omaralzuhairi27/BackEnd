package at.nacs.ex5thecalculator.controller.operation;

import at.nacs.ex5thecalculator.model.Expression;
import at.nacs.ex5thecalculator.model.Operation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MultiplicationTest {

    @Autowired
    Operation multiplication;

    @ParameterizedTest
    @CsvSource({
            "false, +",
            "false, -",
            "true, *",
            "false, /",
    })
    void matches(boolean expected, String symbol) {
        Expression expression = Expression.builder()
                .symbol(symbol)
                .build();

        boolean result = multiplication.matches(expression);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0",
            "0, 0, 1",
            "0, 1, 0",
            "6, 2, 3",
    })
    void apply(double expected, double number1, double number2) {
        Expression expression = Expression.builder()
                .number1(number1)
                .number2(number2)
                .build();

        double result = multiplication.apply(expression);

        assertEquals(expected, result);
    }
}