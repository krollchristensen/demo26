package com.example.demo.demo26.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LayoutDemoController {

    @GetMapping("/layoutDemo")
    public String layoutDemo() {
        return "layoutDemo";
    }
}
