package reflectionWeek1;

import lombok.experimental.UtilityClass;
import reflectionWeek1.controller.FruitReader;
import reflectionWeek1.view.FruitCounter;

import java.util.List;

@UtilityClass
public class FruitShopApp {
    public static void main(String[] args) {
        String filePath = "reflectionWeek1/file/delivery.txt";
        List <String> fruits = FruitReader.asList(filePath);
        FruitCounter.display(fruits);

    }
}
