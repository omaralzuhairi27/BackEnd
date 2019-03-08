package at.nacs.cinemamessagetemplate.configuration;

import at.nacs.cinemamessagetemplate.logic.templates.CreativeTemplate;
import lombok.Setter;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

@Configuration
@ConfigurationProperties("forms")
@EnableConfigurationProperties({TemplateConfiguration.class})
public class TemplateConfiguration {

    @Setter
    private List<CreativeTemplate> templates;

    @Bean
    List<CreativeTemplate> templates() {
        return templates;
    }

}
