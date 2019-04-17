package at.nacs.themagic8ball.controller;

import at.nacs.themagic8ball.logic.Manger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
@RequiredArgsConstructor
public class MageicBallController {

  private final Manger manger;

  @ModelAttribute("message")
  String message(){
    return manger.getMessage();
  }


  @GetMapping
  String page(){
    return "mageic8ball";
  }


}
