package at.nacs.administration.controller;

import at.nacs.administration.client.InvoiceClient;
import at.nacs.administration.domain.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/invoices")
public class InvoicesController {
  private final InvoiceClient manager;

  @ModelAttribute("invoices")
  @RolesAllowed("USER")
  List<Invoice> todos() {
    return manager.getAllInvoive();
  }

  @GetMapping
  String page() {
    return "invoice";
  }

  @PostMapping("/paid")
  String setDone(@RequestParam String id) {
    manager.setPaid(id);
    return "redirect:/invoices";
  }

  @PostMapping("/delete")
  String delete(@RequestParam long id) {
    manager.deleteInvoive(id);
    return "redirect:/invoices";
  }


}