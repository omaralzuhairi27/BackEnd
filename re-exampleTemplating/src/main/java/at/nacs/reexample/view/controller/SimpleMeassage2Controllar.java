package at.nacs.reexample.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/simple/message/2")
public class SimpleMeassage2Controllar {
  @GetMapping
  String page(Model model){
    model.addAttribute("message","Message from Model");
    return "messages/simple-message2";
  }
}
