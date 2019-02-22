package coffeecan.controller.experiment;

import coffeecan.model.Bean;
import coffeecan.model.OverallStatistic;
import coffeecan.model.Statistic;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OverallExperimentTest {

    @ParameterizedTest
    @CsvSource({
            "false, 0",
            "true, 1",
            "true, 2",
            "true, 100"
    })
    void testPerform(boolean expected, int times) {
        Optional<OverallStatistic> statistic = OverallExperiment.perform(times);
        assertEquals(expected, statistic.isPresent());
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "1",
            "2",
            "100"
    })
    void testGatherStatistics(int times) {
        Queue<Bean> beans = IntStream.generate(() -> 0)
                .limit(times)
                .mapToObj(n -> new Bean("black"))
                .collect(Collectors.toCollection(LinkedList::new));

        List<Statistic> statistics = OverallExperiment.gatherStatistics(times);

        assertEquals(times, statistics.size());
    }
}