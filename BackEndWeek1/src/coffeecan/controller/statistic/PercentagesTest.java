package coffeecan.controller.statistic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PercentagesTest {

    @ParameterizedTest
    @CsvSource({
            "0.0, 0, 0",
            "0.0, 0, 10",
            "50.0, 5, 10",
            "100.0, 10, 10",
    })
    void calculate(double expected, int dividend, double divisor) {
        double result = Percentages.calculate(dividend, divisor);

        assertEquals(expected, result);
    }
}