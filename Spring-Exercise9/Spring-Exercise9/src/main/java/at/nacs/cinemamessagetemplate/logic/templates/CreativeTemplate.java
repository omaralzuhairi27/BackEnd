package at.nacs.cinemamessagetemplate.logic.templates;

import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
public class CreativeTemplate {

    private String message;
    private List <String> beginnings;
    private String ending;

    public boolean isValid(String name) {
        return name.endsWith(ending) || beginsWith(name);
    }

    private boolean beginsWith(String name) {
        return beginnings.stream()
                .anyMatch(beginning -> name.startsWith(beginning));
    }

    public String apply(String name) {
        return message.replace("{name}", name);
    }

}
