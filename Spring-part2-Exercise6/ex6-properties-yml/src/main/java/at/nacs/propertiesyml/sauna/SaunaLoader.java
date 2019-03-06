package at.nacs.propertiesyml.sauna;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("leisure")
public class SaunaLoader {

    private Sauna sauna;
}
