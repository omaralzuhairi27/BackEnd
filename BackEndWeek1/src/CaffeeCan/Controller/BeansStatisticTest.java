package CaffeeCan.Controller;

import CaffeeCan.Modle.Bean;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class BeansStatisticTest {

    @Test
    void beansStatistic() {
        Queue <Bean> beans = BeansGenerator.generateBeans(10);
        String s = BeansStatistic.beansStatistic(beans);
        System.out.println(s);
    }
}