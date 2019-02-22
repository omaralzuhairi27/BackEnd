package coffeecan.controller;

import coffeecan.controller.experiment.OverallExperiment;
import coffeecan.model.OverallStatistic;
import coffeecan.view.Screen;

import java.util.Optional;

public class CoffeeCanApp {

    public static void main(String[] args) {
        Optional<OverallStatistic> statistic = OverallExperiment.perform(10);
        statistic.ifPresent(Screen::display);
    }

}
