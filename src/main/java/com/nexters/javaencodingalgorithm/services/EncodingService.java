package com.nexters.javaencodingalgorithm.services;

import com.nexters.javaencodingalgorithm.dto.url.UrlSaveRequestDto;

public interface EncodingService {
    String base62Encode(int inputNumber);

    void save(UrlSaveRequestDto dto);
}
