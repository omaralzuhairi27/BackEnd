package coffeecan.controller.experiment;

import coffeecan.controller.bean.BeanGenerator;
import coffeecan.controller.statistic.OverallStatistics;
import coffeecan.model.Bean;
import coffeecan.model.OverallStatistic;
import coffeecan.model.Statistic;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@UtilityClass
public class OverallExperiment {

    private final int NUMBER_OF_BEANS = 10000;

    public Optional<OverallStatistic> perform(int times) {
        if (times < 1) {
            return Optional.empty();
        }
        List<Statistic> statistics = gatherStatistics(times);
        OverallStatistic overallStatistic = OverallStatistics.from(statistics);
        return Optional.of(overallStatistic);
    }

    List<Statistic> gatherStatistics(int times) {
        return IntStream.generate(() -> 0)
                .limit(times)
                .mapToObj(toRandomizedBeans())
                .map(Scientist::gatherExperimentStatistic)
                .collect(toList());
    }

    private IntFunction<Queue<Bean>> toRandomizedBeans() {
        return n -> BeanGenerator.generate(NUMBER_OF_BEANS);
    }
}
