package coffeecan.controller.experiment.refill;

import coffeecan.controller.bean.Beans;
import coffeecan.model.Bean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EqualsTest {

    RefillStrategy strategy = new Equals();

    @ParameterizedTest
    @CsvSource({
            "false, white, black",
            "false, black, white",
            "true, white, white",
            "true, black, black",
    })
    void isValid(boolean expected, String color1, String color2) {
        Bean bean1 = new Bean(color1);
        Bean bean2 = new Bean(color2);

        boolean result = strategy.isValid(bean1, bean2);

        assertEquals(expected, result);
    }

    @Test
    void getBean() {
        Optional<Bean> result = strategy.getBean();
        
        assertTrue(result.isPresent());
        Bean expected = Beans.getBlack();
        assertEquals(expected, result.get());
    }
}