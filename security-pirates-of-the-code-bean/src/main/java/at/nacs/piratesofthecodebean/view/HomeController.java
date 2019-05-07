package at.nacs.piratesofthecodebean.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
  private final Dutchman dutchman;

  @ModelAttribute("dutchman")
  Dutchman dutchman() {
    return dutchman;
  }

  @GetMapping
  String page() {
    return "home";
  }
}
