package CaffeeCan.Controller;

import CaffeeCan.Modle.Bean;
import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@UtilityClass
public class WriteBeanInFile {

    public void writeBeans(){

        getSeveralBeans(10);

    }

    private void getSeveralBeans(Integer amount) {
        Queue <Bean> beans = BeansGenerator.generateBeans(amount);
         IntStream.generate(()->0)
                .limit(amount)
                .mapToObj(e -> BeansGenerator.generateBeans(amount))
                .map(e ->BeansGenerator.getTheLastElement(e));
                 //.(e -> WritingFiles.append(e,"/home/omr/Desktop/clone/i4-backend/lombok/src/CaffeeCan/File/BeansStatistics.txt"));
    }

    public static void main(String[] args) {
        WriteBeanInFile.writeBeans();
    }
}
