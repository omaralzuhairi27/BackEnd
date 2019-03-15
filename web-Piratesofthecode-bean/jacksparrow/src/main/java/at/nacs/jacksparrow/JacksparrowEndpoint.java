package at.nacs.jacksparrow;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/deadmanschest")
@RequiredArgsConstructor
public class JacksparrowEndpoint {

    private final JackSparrowClient  jackSparrowClient;
    @GetMapping

    String get(){
       return jackSparrowClient.get();
    }



}
