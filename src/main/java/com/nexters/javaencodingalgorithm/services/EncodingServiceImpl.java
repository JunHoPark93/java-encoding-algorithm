package com.nexters.javaencodingalgorithm.services;

import com.nexters.javaencodingalgorithm.domain.url.UrlRepository;
import com.nexters.javaencodingalgorithm.dto.url.UrlSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class EncodingServiceImpl implements EncodingService {

    @Value("${string.regex.base62}")
    private String regexBase62;

    @Value("${encode.base62}")
    private int BASE62;

    @Autowired
    private UrlRepository urlRepository;

    /**
     * Base62로 문자열을 인코딩 한다.
     * @param inputNumber
     * @return
     */
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

    /**
     * Url 도메인을 Dto를 통해서 저장한다.
     * @param dto
     */
    @Override
    @Transactional
    public void save(UrlSaveRequestDto dto) {
        // 여기에서 shortUrl을 매핑 해야 하는데 db에 있는 (url 갯수 + 1) 이 다음 해싱할 숫자
        // 어떻게 가져올까???
        // 일단은 random으로 하드코딩
        Random rand = new Random();
        int n = rand.nextInt(10000) + 1;

        dto.setShortUrl(base62Encode(n));
        urlRepository.save(dto.toEntity());
    }
}
