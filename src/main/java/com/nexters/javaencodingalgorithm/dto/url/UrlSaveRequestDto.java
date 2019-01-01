package com.nexters.javaencodingalgorithm.dto.url;

import com.nexters.javaencodingalgorithm.domain.url.Url;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UrlSaveRequestDto {
    private String longUrl;
    private String shortUrl;

    public Url toEntity() {
        return Url.builder()
                .longUrl(longUrl)
                .shortUrl(shortUrl)
                .build();
    }
}
