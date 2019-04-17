package at.nacs.reexample.view.controller;

import at.nacs.reexample.view.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/message/form")
public class formController {

  private Message message=new Message();

  @ModelAttribute("message")
  Message message(){
    return message;
  }

  @GetMapping
    String page(){
      return "messages/form-message";
    }

    @PostMapping
  String post(Message message, BindingResult result){
    if(result.hasErrors()){
      return page();
    }
    this.message=message;
    return "redirect:/message/form";
  }



}
