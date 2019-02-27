package at.nacs.ex2amazinghelloworld;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AmazingHelloWorld {

    private final Hello hello;
    private final World world;

    public String say() {
        return hello.getHello() + " " + world.getWorld();
    }


}
