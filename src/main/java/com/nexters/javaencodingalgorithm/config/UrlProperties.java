package com.nexters.javaencodingalgorithm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("urls")
public class UrlProperties {
    private String sample1;

    public String getSample1() {
        return sample1;
    }

    public void setSample1(String sample1) {
        this.sample1 = sample1;
    }
}
