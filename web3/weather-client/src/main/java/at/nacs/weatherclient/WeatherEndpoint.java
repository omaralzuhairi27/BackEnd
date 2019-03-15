package at.nacs.weatherclient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherEndpoint {

    private final WeatherClient weatherClient;

    @GetMapping
    public String get() {
        return weatherClient.getWeatherForcastToday();
    }
    @GetMapping("/{city}")
    String ger(@PathVariable String city){
        return weatherClient.getWeatherForcastToday(city);
    }

}
