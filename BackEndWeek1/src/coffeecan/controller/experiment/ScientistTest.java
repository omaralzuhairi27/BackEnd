package coffeecan.controller.experiment;

import coffeecan.model.Bean;
import coffeecan.model.Statistic;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScientistTest {

    @Test
    void testThrowsException() {
        Queue<Bean> beans = new LinkedList<>();
        assertThrows(Exception.class, () -> Scientist.gatherExperimentStatistic(beans));
    }

    @Test
    void testReturnsStatistics() {
        Queue<Bean> beans = Stream.of(new Bean("black")).collect(Collectors.toCollection(LinkedList::new));

        Statistic statistic = Scientist.gatherExperimentStatistic(beans);

        assertNotNull(statistic.getColorOfLastBean());
    }
}