package CaffeeCan.Controller;

import CaffeeCan.Modle.Bean;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

@Log
class BeansGeneratorTest {

    @Test
    void generateBeans() {
        Queue <Bean> beans = BeansGenerator.generateBeans(15);
       // beans.forEach(System.out::println);

    }
    @Test
    void toPairs() {
        Queue <Bean> beans = BeansGenerator.generateBeans(15);
        List <String> theLastElement = BeansGenerator.getTheLastElement(beans);
        System.out.print(theLastElement);

    }

}