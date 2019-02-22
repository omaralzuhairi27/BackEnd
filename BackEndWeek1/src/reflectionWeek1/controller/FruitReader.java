package reflectionWeek1.controller;

import CaffeeCan.Controller.FileReader;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class FruitReader {
    public List <String> asList(String filePath) {
        return FileReader.lines(filePath)
                .collect(Collectors.toList());
    }
}
