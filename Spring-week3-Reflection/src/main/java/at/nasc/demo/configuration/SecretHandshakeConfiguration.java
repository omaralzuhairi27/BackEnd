package at.nasc.demo.configuration;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("handshake")
@EnableConfigurationProperties({SecretHandshakeConfiguration.class})
public class SecretHandshakeConfiguration {

    @Setter
    private Map <Integer, String> moves;

    @Bean
    Map <Integer, String> moves() {
        return moves;
    }
}
