package reflectionWeek1.controller;

import lombok.experimental.UtilityClass;
import reflectionWeek1.model.Fruit;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class Assistant {
    public List <Fruit> getFruitAppernce(List <String> fruits) {
        return fruits.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .map(e -> Fruit.builder().name(e.getKey()).amount(e.getValue()).build())
                .collect(Collectors.toList());
    }


}
