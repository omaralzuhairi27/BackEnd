package reflectionWeek1.view;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import reflectionWeek1.controller.Assistant;
import reflectionWeek1.model.Fruit;

import java.util.List;

@UtilityClass
@Log
public class FruitCounter {

    public void display(List <String> fruits) {
        log.severe("These are all our tasteful fruits:\n");
        List <Fruit> fruitAppernce = Assistant.getFruitAppernce(fruits);
        fruitAppernce.stream()
                .forEach(e -> System.out.println(e.getAmount() + " " + e.getName()));

    }
}
