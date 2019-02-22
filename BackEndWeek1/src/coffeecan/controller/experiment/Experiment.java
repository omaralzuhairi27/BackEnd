package coffeecan.controller.experiment;

import coffeecan.controller.bean.Beans;
import coffeecan.model.Bean;
import lombok.experimental.UtilityClass;

import java.util.Objects;
import java.util.Queue;
import java.util.stream.IntStream;

@UtilityClass
public class Experiment {

    Bean perform(Queue<Bean> beans) {
        reduce(beans);
        Bean lastBean = beans.poll();
        return lastBean;
    }

    void reduce(Queue<Bean> beans) {
        IntStream.generate(() -> 0)
                .takeWhile(n -> beans.size() > 1)
                .mapToObj(n -> getBeanToPutBack(beans))
                .forEach(beans::offer);
    }

    Bean getBeanToPutBack(Queue<Bean> beans) {
        Bean bean1 = beans.poll();
        Bean bean2 = beans.poll();
        if (Objects.equals(bean1, bean2)) {
            return Beans.getBlack();
        }
        return Beans.getWhite();

        // another solution could be to use a refill strategy
        /*
         *
         * return Refill.get(bean1, bean2);
         *
         * */
    }

}
