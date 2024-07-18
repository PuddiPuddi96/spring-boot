package it.davide.course.mainproject.controller;

import it.davide.course.mainproject.model.Customer;
import it.davide.course.mainproject.model.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/show-customer-form")
    public String showCustomerForm(Model model) {

        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/process-customer-form")
    public String processCustomerForm(
            @Valid @ModelAttribute("customer")
            Customer customer,
            BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "customer-form";
        }
        return "customer-confirmation";
    }
}
