package at.nacs.weatherserver;

import lombok.Data;

@Data
public class WeatherForecast {
    private String city;
    private String forecast;
}
