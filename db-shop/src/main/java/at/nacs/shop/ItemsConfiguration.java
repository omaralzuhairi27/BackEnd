package at.nacs.shop;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("dataset")
public class ItemsConfiguration {

    @Setter
    private List <Item> items;


    @Bean
    List<Item> items(){
        return items;
    }

}
