package coffeecan.controller.statistic;

import coffeecan.model.OverallStatistic;
import coffeecan.model.Statistic;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OverallStatisticsTest {

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,1",
            "10,10"
    })
    void prepareOverall(int expected, int amount) {
        Statistic statistic = Statistic.builder().build();
        List<Statistic> statistics = IntStream.range(0, amount)
                .mapToObj(n -> statistic)
                .collect(toList());

        OverallStatistic overallStatistic = OverallStatistics.prepareOverall(statistics);

        assertEquals(expected, overallStatistic.getNumberOfTries());
    }

    @ParameterizedTest
    @CsvSource({
            "0, white",
            "0, black",
            "10, white",
            "10, black"
    })
    void countLast(int expected, String color) {
        List<Statistic> statistics = IntStream.range(0, expected)
                .mapToObj(n -> Statistic.builder().colorOfLastBean(color).build())
                .collect(toList());

        long result = statistics.stream().map(Statistic::getColorOfLastBean).filter(e -> Objects.equals(e, color)).count();

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "4, 1",
            "8, 2"
    })
    void sum(int expected, int times) {
        Statistic statistic = Statistic.builder()
                .numberOfWhiteBeans(4)
                .numberOfBlackBeans(4)
                .build();
        List<Statistic> statistics = IntStream.range(0, times)
                .mapToObj(n -> statistic)
                .collect(toList());

        long whites = OverallStatistics.sum(statistics, Statistic::getNumberOfWhiteBeans);
        long blacks = OverallStatistics.sum(statistics, Statistic::getNumberOfBlackBeans);

        assertEquals(expected, whites);
        assertEquals(expected, blacks);
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 0",
            "50.0, 1",
            "50.0, 10"
    })
    void calculateAppearancePercentages(double expected, int times) {
        int appearances = 4 * times;
        OverallStatistic overall = OverallStatistic.builder()
                .numberOfWhiteBeans(appearances)
                .numberOfBlackBeans(appearances)
                .build();

        OverallStatistics.calculateAppearancePercentages(overall);

        assertEquals(expected, overall.getPercentageOfWhiteBeans());
        assertEquals(expected, overall.getPercentageOfBlackBeans());
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 0",
            "50.0, 1",
            "50.0, 10"
    })
    void calculateLastBeanPercentages(double expected, int times) {
        int appearances = 4 * times;
        OverallStatistic overall = OverallStatistic.builder()
                .numberOfTimesLastBeanWasWhite(appearances)
                .numberOfTimesLastBeanWasBlack(appearances)
                .build();

        OverallStatistics.calculateLastBeanPercentages(overall);

        assertEquals(expected, overall.getPercentageOfTimesLastBeanWasWhite());
        assertEquals(expected, overall.getPercentageOfTimesLastBeanWasBlack());
    }
}