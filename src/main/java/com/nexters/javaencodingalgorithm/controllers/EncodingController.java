package com.nexters.javaencodingalgorithm.controllers;

import com.nexters.javaencodingalgorithm.services.EncodingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EncodingController {

    private final EncodingService encodingService;

    public EncodingController(EncodingService encodingService) {
        this.encodingService = encodingService;
    }

    @GetMapping("/encode")
    public String initEncode(Model model) {
        // 일단은 inputNumber는 하드코딩
        String result = encodingService.base62Encode(938212);

        model.addAttribute("url", result);

        return "encodingPage";
    }
}
