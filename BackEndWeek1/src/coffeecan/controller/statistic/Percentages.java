package coffeecan.controller.statistic;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Percentages {

    public double calculate(long dividend, double divisor) {
        if (divisor == 0) {
            return 0;
        }
        return dividend * 100 / divisor;
    }

}
