package at.nacs.ex5thecalculator.controller;

import at.nacs.ex5thecalculator.model.Expression;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalculatorTest {

    @Autowired
    Calculator calculator;

    @ParameterizedTest
    @CsvSource({
            "2, 1, +, 1",
            "0, 1, -, 1",
            "1, 1, *, 1",
            "1, 1, /, 1",
    })
    void calculateSucceeds(double expected, double number1, String symbol, double number2) {
        Expression expression = Expression.builder()
                .number1(number1)
                .symbol(symbol)
                .number2(number2)
                .build();

        double result = calculator.calculate(expression);

        assertEquals(expected, result);
    }

    @Test
    void calculateFailsBecauseOfUnknownSymbol() {
        String unknownSymbol = "$";
        Expression expression = Expression.builder()
                .number1(1)
                .symbol(unknownSymbol)
                .number2(1)
                .build();

        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(expression));
    }
}