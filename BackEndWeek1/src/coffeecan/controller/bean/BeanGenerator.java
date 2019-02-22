package coffeecan.controller.bean;

import coffeecan.model.Bean;
import lombok.experimental.UtilityClass;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class BeanGenerator {

    private Random random = new Random();

    public Queue<Bean> generate(int amount) {
        return IntStream.generate(() -> 0)
                .limit(amount)
                .mapToObj(n -> random.nextBoolean())
                .map(BeanGenerator::toBean)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    Bean toBean(Boolean isWhite) {
        if (isWhite) {
            return Beans.getWhite();
        }
        return Beans.getBlack();
    }

}
