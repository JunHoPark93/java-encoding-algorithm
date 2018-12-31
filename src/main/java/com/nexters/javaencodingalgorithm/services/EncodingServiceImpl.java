package com.nexters.javaencodingalgorithm.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EncodingServiceImpl implements EncodingService {

    @Value("${string.regex.base62}")
    private String regexBase62;

    @Value("${encode.base62}")
    private int BASE62;

    @Override
    public String base62Encode(int inputNumber) {
        char[] table = regexBase62.toCharArray();
        StringBuffer sb = new StringBuffer();

        while(inputNumber > 0) {
            sb.append(table[inputNumber % BASE62]);
            inputNumber = inputNumber / BASE62;
        }

        return sb.toString();
    }
}
