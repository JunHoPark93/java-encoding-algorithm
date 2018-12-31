package com.nexters.javaencodingalgorithm.controllers;

import com.nexters.javaencodingalgorithm.config.UrlProperties;
import com.nexters.javaencodingalgorithm.services.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    private final MainService mainService;

    @Autowired
    private UrlProperties urlProperties;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/")
    public String initMain() {
        // base 64하려면 주석 해제
        //byte[] temp = mainService.encodeStringWithBase64("text");
        //byte[] result = mainService.decodeBytesWithBase64(temp);
        String result;
        try {
            result = mainService.encodeStringWithMD5(urlProperties.getSample1());
        } catch (NoSuchAlgorithmException e) {
            logger.error("You should check message digest : " + e);
            return "Error";
        }
        return result;
    }
}
