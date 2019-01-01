package com.nexters.javaencodingalgorithm.controllers;

import com.nexters.javaencodingalgorithm.dto.url.UrlSaveRequestDto;
import com.nexters.javaencodingalgorithm.services.EncodingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncodingController {

    private final EncodingService encodingService;

    public EncodingController(EncodingService encodingService) {
        this.encodingService = encodingService;
    }

    @GetMapping(value = "/encode")
    public String initEncode(Model model) {
        return "encodingPage";
    }

    @PostMapping(value = "/encode")
    public String saveUrl(UrlSaveRequestDto dto) {
        encodingService.save(dto);
        return "encodingPage";
    }
}
