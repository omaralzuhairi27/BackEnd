package coffeecan.controller.statistic;

import coffeecan.model.OverallStatistic;
import coffeecan.model.Statistic;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Objects;
import java.util.function.ToLongFunction;

@UtilityClass
public class OverallStatistics {

    public OverallStatistic from(List<Statistic> statistics) {
        OverallStatistic overallStatistic = prepareOverall(statistics);
        calculatePercentages(overallStatistic);
        return overallStatistic;
    }

    OverallStatistic prepareOverall(List<Statistic> statistics) {
        return OverallStatistic.builder()
                .numberOfTries(statistics.size())
                .numberOfWhiteBeans(sum(statistics, Statistic::getNumberOfWhiteBeans))
                .numberOfBlackBeans(sum(statistics, Statistic::getNumberOfBlackBeans))
                .numberOfTimesLastBeanWasWhite(statistics.stream().map(Statistic::getColorOfLastBean).filter(e1 -> Objects.equals(e1, "white")).count())
                .numberOfTimesLastBeanWasBlack(statistics.stream().map(Statistic::getColorOfLastBean).filter(e -> Objects.equals(e, "black")).count())
                .build();
    }

    long sum(List<Statistic> statistics, ToLongFunction<Statistic> mapper) {
        return statistics.stream().mapToLong(mapper).sum();
    }

    private void calculatePercentages(OverallStatistic overallStatistic) {
        calculateAppearancePercentages(overallStatistic);
        calculateLastBeanPercentages(overallStatistic);
    }

    void calculateAppearancePercentages(OverallStatistic overallStatistic) {
        long whites = overallStatistic.getNumberOfWhiteBeans();
        long blacks = overallStatistic.getNumberOfBlackBeans();
        long total = whites + blacks;

        overallStatistic.setPercentageOfWhiteBeans(Percentages.calculate(whites, total));
        overallStatistic.setPercentageOfBlackBeans(Percentages.calculate(blacks, total));
    }

    void calculateLastBeanPercentages(OverallStatistic overallStatistic) {
        long whites = overallStatistic.getNumberOfTimesLastBeanWasWhite();
        long blacks = overallStatistic.getNumberOfTimesLastBeanWasBlack();
        long total = whites + blacks;
        overallStatistic.setPercentageOfTimesLastBeanWasWhite(Percentages.calculate(whites, total));
        overallStatistic.setPercentageOfTimesLastBeanWasBlack(Percentages.calculate(blacks, total));
    }

}
