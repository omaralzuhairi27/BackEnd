package at.nacs.ex6propertiesproperties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FirstClass {

    @Getter
    @Value("${words.first}")
    private String word;


    @Getter
    @Value("${number.first}")
    private Integer number;

    @Getter
    @Value("${week.days}")
    private List<String> weekDays;

}
