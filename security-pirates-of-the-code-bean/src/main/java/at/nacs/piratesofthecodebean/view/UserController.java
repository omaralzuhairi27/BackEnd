package at.nacs.piratesofthecodebean.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@Controller
@RequestMapping("/diary")
@RequiredArgsConstructor
public class UserController {

  private final Dutchman dutchman;

  @GetMapping
  String page() {
    return "diary";
  }

  @PostMapping
  @RolesAllowed("CARINA")
  String set() {
    dutchman.setCursed(false);
    return "redirect:/";

  }


}
