package com.nexters.javaencodingalgorithm.domain;

import com.nexters.javaencodingalgorithm.domain.url.Url;
import com.nexters.javaencodingalgorithm.domain.url.UrlRepository;
import com.nexters.javaencodingalgorithm.services.EncodingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UrlRepositoryTest {

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private EncodingService encodingService;

    @Test
    public void save_Url저장() {
        // given
        String shortUrl = encodingService.base62Encode(88999);
        String longUrl = "ohmygodsolooonnnggggggg";

        // when
        Url url = urlRepository.save(Url.builder().longUrl(longUrl).shortUrl(shortUrl).build());

        // then
        assertEquals("ohmygodsolooonnnggggggg", url.getLongUrl());
    }
}
