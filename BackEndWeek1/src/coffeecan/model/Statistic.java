package coffeecan.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Statistic {

    private long numberOfWhiteBeans;
    private long numberOfBlackBeans;

    private double percentageOfWhiteBeans;
    private double percentageOfBlackBeans;

    private String colorOfLastBean;
}
