package at.nacs.marathonclient.configuration;

import at.nacs.marathonclient.domain.Runner;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("dataset")
public class RunnersConfiguration {

    @Setter
    private List<Runner> runners;

    @Setter
    private String winner;

    @Bean
    List<Runner> runners() {
        System.out.println(runners);
        return runners;
    }

    @Bean
    String winner() {
        return winner;
    }


}
