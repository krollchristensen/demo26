package com.example.demo.demo26.controller;

import com.example.demo.demo26.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller til at håndtere Person-relaterede anmodninger.
 */
@Controller
public class PersonController {

    /**
     * Viser en person med forudbestemte data.
     * @param model Model til at tilføje attributter for visning i skabelonen.
     * @return Navnet på Thymeleaf-skabelonen, der viser personens data.
     * Der bør være et servicelag 
     */
    @GetMapping("/showPerson")
    public String showPerson(Model model) {
        // Opretter en ny person med eksempeldata.
        Person person = new Person("John Doe", 30);
        // Tilføjer personobjektet til modellen, så det kan vises i skabelonen.
        model.addAttribute("person", person);
        return "person";
    }
}
