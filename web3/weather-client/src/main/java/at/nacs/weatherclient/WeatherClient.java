package at.nacs.weatherclient;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherClient {

    private final RestTemplate restTemplate;

    @Value("${weather.server.url}")
    private String url;
    public String getWeatherForcastToday() {
        String forecast = restTemplate.getForObject(url, String.class);
        return "Client: "+forecast;
    }

    public String getWeatherForcastToday(String city) {
        String forecast = restTemplate.getForObject(url + "/" + city, String.class);
        return "Client: "+forecast;

    }
}
