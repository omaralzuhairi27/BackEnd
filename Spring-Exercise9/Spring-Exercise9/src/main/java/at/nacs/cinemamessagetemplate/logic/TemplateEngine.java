package at.nacs.cinemamessagetemplate.logic;

import at.nacs.cinemamessagetemplate.logic.templates.CreativeTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class TemplateEngine {

    private final List<CreativeTemplate> templates;

    public String getMatchingTemplate(String name) {
        return templates.stream()
                .filter(e -> e.isValid(name))
                .map(e -> e.apply(name))
                .findFirst().orElseThrow(templateNotFound(name));
    }

    private Supplier <IllegalArgumentException> templateNotFound(String name) {
        return () -> new IllegalArgumentException("Could not find a template for name: " + name);
    }


}
