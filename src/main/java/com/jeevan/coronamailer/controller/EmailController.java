package com.jeevan.coronamailer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jeevan.coronamailer.model.EmailModel;
import com.jeevan.coronamailer.repository.EmailRepository;
import com.jeevan.coronamailer.service.EmailService;

@Controller
public class EmailController {

    private EmailRepository repository;
    private EmailService service;

    @Autowired
    public EmailController(EmailRepository repository, EmailService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping()
    public String showForm(Model model){

        EmailModel email = new EmailModel();

        model.addAttribute("countryList",service.getCountryList());
        model.addAttribute("emailobj",email);
        return "form";
    }

    @PostMapping("/subscribe")
    public String emailRegistration(@ModelAttribute("emailobj") EmailModel email,Model model){
        System.out.println(email);
        if(repository.existsByEmail(email.getEmail())){
            System.err.println("Email already exists");
            model.addAttribute("emailExists",true);
            model.addAttribute("countryList",service.getCountryList());
            model.addAttribute("errorMsg","Email already exists");
            return "form";
        }else{
            System.out.println("Saving email");
            repository.save(email);
            return "success";
        }

    }
}
