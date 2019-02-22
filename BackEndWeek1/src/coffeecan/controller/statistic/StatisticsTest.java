package coffeecan.controller.statistic;

import coffeecan.model.Bean;
import coffeecan.model.Statistic;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticsTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0.0",
            "1, 50.0",
            "10, 50.0"
    })
    void prepareStatistic(int times, double expected) {
        Queue<Bean> beans = new LinkedList<>();
        IntStream.range(0, times)
                .forEach(n -> {
                    beans.offer(new Bean("white"));
                    beans.offer(new Bean("black"));
                });

        Statistic statistic = Statistics.prepareStatistic(beans);

        assertEquals(expected, statistic.getPercentageOfWhiteBeans());
        assertEquals(expected, statistic.getPercentageOfBlackBeans());
    }

  
}