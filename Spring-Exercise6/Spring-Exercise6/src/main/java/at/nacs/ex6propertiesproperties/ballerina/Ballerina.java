package at.nacs.ex6propertiesproperties.ballerina;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
public class Ballerina {

    private String name;
    private int performanceQuality;
}
