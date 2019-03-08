package at.nacs.cinemamessagetemplate.ui;

import org.springframework.stereotype.Component;

@Component
public class TextMessageSender {

    public void display(String message){
        System.out.println(message);
    }
}
