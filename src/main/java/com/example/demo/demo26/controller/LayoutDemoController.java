package com.example.demo.demo26.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller til at demonstrere forskellige layouts.
 */
@Controller
public class LayoutDemoController {

    /**
     * Viser et eksempel på layout.
     * @return Navnet på Thymeleaf-skabelonen for layout-demonstrationen.
     */
    @GetMapping("/layoutDemo")
    public String layoutDemo() {
        return "layoutDemo";
    }
}
