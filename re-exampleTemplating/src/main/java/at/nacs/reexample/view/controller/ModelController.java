package at.nacs.reexample.view.controller;

import at.nacs.reexample.view.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.MessageDigest;

@Controller
@RequestMapping("/message/model")
public class ModelController {

  @ModelAttribute("message")
  Message message(){
   return Message.builder()
           .text("from the modell")
           .build();
  }

  @GetMapping
  String page(){
    return "messages/model-message";
  }

}
