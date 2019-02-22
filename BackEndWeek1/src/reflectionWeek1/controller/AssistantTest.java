package reflectionWeek1.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import reflectionWeek1.model.Fruit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AssistantTest {
    //private List <Fruit> fruits = FruitReader.asList("reflectionWeek1/file/delivery.txt");
    @ParameterizedTest
    @CsvSource({

            "1, 3  ,orang apple apple apple",
    })
    void asList(Long amount, String name) {
        List <String> fruitNames = Stream.of(name)
                .map(e -> e.split(" "))
                .flatMap(Stream::of)
                .collect(Collectors.toList());

        List <Fruit> fruitAppernce = Assistant.getFruitAppernce(fruitNames);
        boolean allmatched = fruitAppernce.stream()
                .map(e -> e.getAmount())
                .allMatch(e -> e.equals(amount));

        assertEquals(true, allmatched);
    }

}