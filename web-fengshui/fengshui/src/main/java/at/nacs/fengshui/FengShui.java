package at.nacs.fengshui;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

// dbe484YCj46B7xBl0f3hj20dZ28M40ecdAc4b084
@RestController
@RequiredArgsConstructor
public class FengShui {
    private final RestTemplate restTemplate;

    String test() {
        String url = "https://fengshui-api.com/api/v1/findChineseSignOfYear?token=dbe484YCj46B7xBl0f3hj20dZ28M40ecdAc4b084&year=2013&month=8&day=2&gender=0";
        return restTemplate.getForObject(url, String.class);
    }

    String getSign(LocalDate birthday) {
        String url = "https://fengshui-api.com/api/v1/findChineseSignOfYear?token=dbe484YCj46B7xBl0f3hj20dZ28M40ecdAc4b084&year=" + birthday.getYear() + "&month=" + birthday.getMonth().getValue() + "&day=" + birthday.getDayOfMonth();
        Sign name = restTemplate.getForObject(url, Sign.class);
        return name.getResult();
    }

    String findLoveCompatibility(LocalDate birthday1, LocalDate birthday2) {
        String url = "https://fengshui-api.com/api/v1/findLoveCompatibility?token=dbe484YCj46B7xBl0f3hj20dZ28M40ecdAc4b084&year=" + birthday1.getYear() + "&month=" + birthday1.getMonth().getValue() + "&day=" + birthday1.getDayOfMonth() + "&year2=" + birthday2.getYear() + "&month2=" + birthday2.getMonth().getValue() + "&day2=" + birthday2.getDayOfMonth();
        return restTemplate.getForObject(url, String.class);
    }

    String findSignCompatibility(LocalDate birthday1, LocalDate birthday2) {
        String sign = getSign(birthday1);
        String sign1 = getSign(birthday2);
        String url = "https://fengshui-api.com/api/v1/findSignCompatibility?token=dbe484YCj46B7xBl0f3hj20dZ28M40ecdAc4b084&sign=" + sign + "&sign2=" + sign1;
        return restTemplate.getForObject(url, String.class);
    }


}

