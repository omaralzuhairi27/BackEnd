package coffeecan.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OverallStatistic {

    private int numberOfTries;

    private long numberOfWhiteBeans;
    private long numberOfBlackBeans;

    private double percentageOfWhiteBeans;
    private double percentageOfBlackBeans;

    private long numberOfTimesLastBeanWasWhite;
    private long numberOfTimesLastBeanWasBlack;

    private double percentageOfTimesLastBeanWasWhite;
    private double percentageOfTimesLastBeanWasBlack;

}
