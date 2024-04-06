package com.example.demo.demo26.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // Tilføj data til dropdown
        List<String> options = Arrays.asList("Option 1", "Option 2", "Option 3");
        model.addAttribute("options", options);

        // Tilføj standardværdier til tjekbokse
        model.addAttribute("isChecked", false);

        return "index";
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("image") MultipartFile image, HttpServletRequest request, Model model) throws IOException {
        String uploadDirPath = request.getServletContext().getRealPath("/uploads");
        Path uploadPath = Paths.get(uploadDirPath);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String filename = image.getOriginalFilename();
        File file = new File(uploadDirPath, filename);
        image.transferTo(file);

        // Gemmer den relative sti til filen for at vise den i viewet
        model.addAttribute("uploadedFilePath", "/uploads/" + filename);
        model.addAttribute("message", "Fil uploadet succesfuldt: " + filename);

        return "index";
    }

    @GetMapping("/cssDemo")
    public String cssDemo() {
        return "cssDemo";
    }
    @GetMapping("/tableDemo")
    public String tableDemo() {
        return "tableDemo";
    }


}
