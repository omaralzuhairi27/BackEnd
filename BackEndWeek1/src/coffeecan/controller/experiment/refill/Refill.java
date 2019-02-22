package coffeecan.controller.experiment.refill;

import coffeecan.model.Bean;
import lombok.experimental.UtilityClass;

import java.util.Optional;
import java.util.Set;

@UtilityClass
public class Refill {

    private Set<RefillStrategy> strategies = Set.of(new Equals(), new Different());

    public Bean get(Bean bean1, Bean bean2) {
        return strategies.stream()
                .map(strategy -> strategy.get(bean1, bean2))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst().orElseThrow();
    }

}
