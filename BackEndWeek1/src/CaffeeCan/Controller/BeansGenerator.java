package CaffeeCan.Controller;
import CaffeeCan.Modle.Bean;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
@UtilityClass
@Log
public class BeansGenerator {

    private static Random random = new Random();

    public Queue <Bean> generateBeans(int amount) {
        return IntStream.generate(() -> 0)
                .limit(amount)
                .mapToObj(n -> random.nextBoolean())
                .map(b -> b ? "white" : "black")
                .map(color -> Bean.builder().color(color).build())
                .collect(toCollection(LinkedList::new));
    }

    public List<String> getTheLastElement(Queue <Bean> beans) {
        IntStream.generate(() -> 0)
                .takeWhile(n -> beans.size() > 1)
                .mapToObj((a1 -> t
                .map(b -> b ? beans.add(Bean.builder().color("black").build()) : beans.add(Bean.builder().color("white").build()))
                .collect(Collectors.toList());
        return (List)beans;

    }



}