package at.nacs.weatherserver;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/weather")
public class WeatherEndpoint {

    private Map<String,String> forecasts =new HashMap <>();

    @GetMapping
    String get(){
        return "The weather is awesome";
    }
    @GetMapping("/{city}")
    String ger(@PathVariable String city){
        return forecasts.get(city);
    }

    @PostMapping
    WeatherForecast post(@RequestBody WeatherForecast forecast){
        forecasts.put(forecast.getCity(),forecast.getForecast());
        return forecast;
    }
}
