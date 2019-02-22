package coffeecan.controller.experiment;

import coffeecan.controller.bean.Beans;
import coffeecan.model.Bean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ExperimentTest {

    @Test
    void testPerformReturnsNull() {
        Queue<Bean> queue = new LinkedList<>();

        Bean lastBean = Experiment.perform(queue);

        assertNull(lastBean);
    }

    @Test
    void testPerformReturnsLastBean() {
        Queue<Bean> queue = Stream.of(Beans.getWhite(), Beans.getBlack()).collect(Collectors.toCollection(LinkedList::new));

        Bean lastBean = Experiment.perform(queue);

        assertNotNull(lastBean);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,1",
            "1,2",
            "1,1000"
    })
    void testReduce(int finalNumberOfBeans, int initialNumberOfBeans) {
        Queue<Bean> beans = createTestBeans(initialNumberOfBeans);
        assertEquals(initialNumberOfBeans, beans.size());

        Experiment.reduce(beans);
        assertEquals(finalNumberOfBeans, beans.size());
    }

    private LinkedList<Bean> createTestBeans(int initialNumberOfBeans) {
        return IntStream.range(0, initialNumberOfBeans)
                .mapToObj(n -> Beans.getWhite())
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @ParameterizedTest
    @CsvSource({
            "black, white, white",
            "black, black, black",
            "white, white, black",
            "white, black, white"
    })
    void testGetBeanToPutBack(String expected, String color1, String color2) {
        Bean bean1 = new Bean(color1);
        Bean bean2 = new Bean(color2);
        Queue<Bean> beans = Stream.of(bean1, bean2).collect(Collectors.toCollection(LinkedList::new));

        Bean result = Experiment.getBeanToPutBack(beans);

        assertEquals(expected, result.getColor());
    }
}