package at.nacs.propertiesyml.ballerina;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@ConfigurationProperties("dancers")
public class BallerinaLoader {

    private List<Ballerina> ballerinas;
}
