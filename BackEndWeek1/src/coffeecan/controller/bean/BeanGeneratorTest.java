package coffeecan.controller.bean;

import coffeecan.model.Bean;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BeanGeneratorTest {

    @ParameterizedTest
    @CsvSource({
            "0",
            "1",
            "2",
            "100"
    })
    void generate(int amount) {
        Queue<Bean> beans = BeanGenerator.generate(amount);

        assertEquals(amount, beans.size());
    }

    @ParameterizedTest
    @CsvSource({
            "white, true",
            "black, false"
    })
    void toBean(String expected, boolean isWhite) {
        Bean bean = BeanGenerator.toBean(isWhite);
        assertEquals(expected, bean.getColor());
    }
}