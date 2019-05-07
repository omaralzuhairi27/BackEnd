package at.nacs.administration.controller;

import at.nacs.administration.client.AdmisstionClient;
import at.nacs.administration.domain.Patient;
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

  private final AdmisstionClient admisstionClient;

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
    admisstionClient.post(patient);
    return "redirect:/";
  }

}
