package at.nacs.administration.controller;

import at.nacs.administration.domain.Patient;
import at.nacs.administration.logic.Manger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

  private final Manger manger;

  @ModelAttribute("patient")
  Patient patient() {
    return new Patient();
  }

  @GetMapping
  String page() {
    return "home";
  }

  @PostMapping
  String post(@Valid Patient patient, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    manger.post(patient);
    return "redirect:/";
  }

}
