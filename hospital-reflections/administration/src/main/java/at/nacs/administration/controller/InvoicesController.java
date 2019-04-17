package at.nacs.administration.controller;

import at.nacs.administration.domain.Invoice;
import at.nacs.administration.logic.InvoiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/invoices")
public class InvoicesController {
  private final InvoiceManager manager;

  @ModelAttribute("invoices")
  List<Invoice> todos() {
    List<Invoice> invoices = manager.getAllInvoive();
    return invoices;
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
//"/invoices/{id}/delete"