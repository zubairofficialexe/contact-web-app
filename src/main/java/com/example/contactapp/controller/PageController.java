package com.example.contactapp.controller;

import com.example.contactapp.entity.ContactSubmission;
import com.example.contactapp.service.ContactSubmissionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class PageController {

    private final ContactSubmissionService service;

    public PageController(ContactSubmissionService service) {
        this.service = service;
    }

    @GetMapping
    public String home(Model model) {
        if (!model.containsAttribute("contactSubmission")) {
            model.addAttribute("contactSubmission", new ContactSubmission());
        }
        return "contact";
    }

    @PostMapping("contact")
    public String submitContact(@Valid @ModelAttribute("contactSubmission") ContactSubmission contactSubmission,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contactSubmission", contactSubmission);
            return "contact";
        }

        service.save(contactSubmission);
        redirectAttributes.addFlashAttribute("successMessage", "Your message has been submitted successfully.");
        return "redirect:/";
    }

    @GetMapping("admin")
    public String admin(Model model) {
        model.addAttribute("submissions", service.findAllLatestFirst());
        return "admin";
    }
}
