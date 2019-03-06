package at.nacs.propertiesyml;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties("book")
public class BookShop {

    @Setter
    private Map<String, Integer> quantity;

    public Map<String, Integer> getQuantity() {
        Map<String, Integer> newMap = new HashMap<>();
        quantity.forEach((key, value) -> newMap.put(key.replace("_", " "), value));
        return newMap;
    }
}
