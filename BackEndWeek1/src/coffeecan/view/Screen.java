package coffeecan.view;

import coffeecan.model.OverallStatistic;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Screen {

    public void display(OverallStatistic statistic) {
        System.out.println("\n--- Statistics ---\n");

        System.out.println("Number of tries: " + statistic.getNumberOfTries());
        System.out.println("Total number of white beans: " + statistic.getNumberOfWhiteBeans());
        System.out.println("Total number of black beans: " + statistic.getNumberOfBlackBeans());
        System.out.println("Number of times where the last bean was white: " + statistic.getNumberOfTimesLastBeanWasWhite());
        System.out.println("Number of times where the last bean was black: " + statistic.getNumberOfTimesLastBeanWasBlack());
        System.out.println("Total bean ratio: " + statistic.getPercentageOfWhiteBeans() + "% white " + statistic.getPercentageOfBlackBeans() + " % black");
        System.out.println("Total last bean ratio: " + statistic.getPercentageOfTimesLastBeanWasWhite() + "% white " + statistic.getPercentageOfTimesLastBeanWasBlack() + " % black");

        System.out.println("\n--- Statistics ---");
    }

}
