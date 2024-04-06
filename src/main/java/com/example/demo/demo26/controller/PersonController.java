package com.example.demo.demo26.controller;

import com.example.demo.demo26.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {
/*
I en ideel, produktionsklar applikation, især dem der følger et lagdelt
 arkitekturprincip, ville det være mere passende at adskille bekymringerne
 yderligere ved at introducere et service-lag (eller bruge-case-klasse)
 mellem controlleren og domænemodellen. Dette lag håndterer forretningslogikken
 og interaktionen med datalageret (som kan være en database, en ekstern API,
 eller noget andet). Det betyder, at controlleren ikke direkte opretter eller
 manipulerer Person-objekter, men i stedet kalder metoder på service-laget,
 som så tager sig af disse opgaver.
 */
    @GetMapping("/showPerson")
    public String showPerson(Model model) {
        Person person = new Person("John Doe", 30);
        model.addAttribute("person", person);
        return "person";
    }
}
