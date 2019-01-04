package com.nexters.javaencodingalgorithm.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EncodingServiceImplTest {

    @Value("${string.regex.base62}")
    private String regexBase62;

    @Value("${encode.base62}")
    private int BASE62;

    @Autowired
    private EncodingService encodingService;

    private String base62matchPattern;

    @Before
    public void before() {
        base62matchPattern = "^([A-Za-z0-9]*)$";
    }

    @Test
    public void base62Encode_해시값_테스트() {
        // given
        int n1 = 0;
        int n2 = 3;
        int n3 = 100;
        int n4 = 9999999;
        int n5 = 2000000000;

        // when
        String s1 = encodingService.base62Encode(n1);
        String s2 = encodingService.base62Encode(n2);
        String s3 = encodingService.base62Encode(n3);
        String s4 = encodingService.base62Encode(n4);
        String s5 = encodingService.base62Encode(n5);

        // then
        assertEquals("", s1);
        assertEquals(true, s2.matches(base62matchPattern));
        assertEquals(true, s3.matches(base62matchPattern));
        assertEquals(true, s4.matches(base62matchPattern));
        assertEquals(true, s5.matches(base62matchPattern));
    }
}