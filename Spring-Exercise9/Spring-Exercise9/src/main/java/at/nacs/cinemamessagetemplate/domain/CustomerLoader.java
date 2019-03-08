package at.nacs.cinemamessagetemplate.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ConfigurationProperties("customer")
public class CustomerLoader {

    private List<String> names;
}
