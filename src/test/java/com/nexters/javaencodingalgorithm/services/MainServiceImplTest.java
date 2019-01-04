package com.nexters.javaencodingalgorithm.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Base64;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MainServiceImplTest {

    @Value("${urls.sample1}")
    String url;

    private String base64matchPattern;

    @Before
    public void before() {
        base64matchPattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$";
    }

    @Test
    public void encodeStringWithBase64() {

        byte[] targetBytes = url.getBytes();
        Base64.Encoder encoder = Base64.getEncoder();

        String s = new String(encoder.encode(targetBytes));
        assertEquals(true, s.matches(base64matchPattern));
    }

    @Test
    public void encodeStringWithMD5() {
    }

    @Test
    public void encodeStringWithSHA256() {
    }
}