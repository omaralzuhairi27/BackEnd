package at.nacs.cinemamessagetemplate.logic;

import at.nacs.cinemamessagetemplate.domain.CustomerLoader;
import at.nacs.cinemamessagetemplate.ui.TextMessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CinemaMessageSender {

    private final TemplateEngine templateEngine;
    private final TextMessageSender textMessageSender;
    private final CustomerLoader customerLoader;

    public void sendMessages() {
        List<String> customers = customerLoader.getNames();
        customers.stream()
                .map(templateEngine::getMatchingTemplate)
                .forEach(textMessageSender::display);
    }

}
