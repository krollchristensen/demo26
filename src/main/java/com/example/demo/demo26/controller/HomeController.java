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

/**
 * Controller til hovedfunktionerne i applikationen.
 * Håndterer visning af startsiden, upload af billeder samt CSS og tabel-demonstrationer.
 */
@Controller
public class HomeController {

    /**
     * Viser startsiden med formular til upload og eksempler på brugerinteraktion.
     * @param model Bruges til at tilføje attributter, der skal vises på siden.
     * @return Navnet på Thymeleaf-skabelonen til index-siden.
     */
    @GetMapping("/")
    public String home(Model model) {
        // Tilføjer en liste af muligheder til en dropdown på siden.
        List<String> options = Arrays.asList("Option 1", "Option 2", "Option 3");
        model.addAttribute("options", options);

        // Tilføjer en standardværdi til en tjekboks.
        model.addAttribute("isChecked", false);

        return "index"; // Returnerer index.html Thymeleaf-skabelonen.
    }

    /**
     * Behandler indsendelsen af billedupload-formularen.
     * @param image Det uploadede billede.
     * @param request Bruges til at finde stien, hvor billedet skal gemmes.
     * @param model Bruges til at sende data tilbage til skabelonen.
     * @return Navnet på Thymeleaf-skabelonen, typisk genvisning af index-siden med en bekræftelse.
     * @throws IOException Håndterer fejl i filhåndtering.
     */
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("image") MultipartFile image, HttpServletRequest request, Model model) throws IOException {
        // Finder stien til upload-mappen og opretter den, hvis den ikke findes.
        String uploadDirPath = request.getServletContext().getRealPath("/uploads");
        Path uploadPath = Paths.get(uploadDirPath);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Gemmer det uploadede billede i upload-mappen.
        String filename = image.getOriginalFilename();
        File file = new File(uploadDirPath, filename);
        image.transferTo(file);

        // Sender stien til det uploadede billede tilbage til skabelonen.
        model.addAttribute("uploadedFilePath", "/uploads/" + filename);
        model.addAttribute("message", "Fil uploadet succesfuldt: " + filename);

        return "index"; // Genviser index-siden med beskeden om succesfuld upload.
    }

    /**
     * Viser en demo af CSS-styling.
     * @return Navnet på Thymeleaf-skabelonen for CSS-demoen.
     */
    @GetMapping("/cssDemo")
    public String cssDemo() {
        return "cssDemo";
    }

    /**
     * Viser en demo af tabel-layout.
     * @return Navnet på Thymeleaf-skabelonen for tabel-demoen.
     */
    @GetMapping("/tableDemo")
    public String tableDemo() {
        return "tableDemo";
    }
}
