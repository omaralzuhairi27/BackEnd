package coffeecan.controller.experiment;

import coffeecan.controller.statistic.Statistics;
import coffeecan.model.Bean;
import coffeecan.model.Statistic;
import lombok.experimental.UtilityClass;

import java.util.Queue;

@UtilityClass
public class Scientist {

    public Statistic gatherExperimentStatistic(Queue<Bean> beans) {
        Statistic statistic = Statistics.prepareStatistic(beans);
        Bean lastBean = Experiment.perform(beans);
        statistic.setColorOfLastBean(lastBean.getColor());
        return statistic;
    }
}
