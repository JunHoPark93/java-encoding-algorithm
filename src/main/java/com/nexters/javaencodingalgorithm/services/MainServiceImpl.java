package com.nexters.javaencodingalgorithm.services;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class MainServiceImpl implements MainService {

    /**
     * Base 64로 문자열을 인코딩한다.
     * @param targetString
     * @return
     */
    @Override
    public byte[] encodeStringWithBase64(String targetString) {
        byte[] targetBytes = targetString.getBytes();
        Base64.Encoder encoder = Base64.getEncoder();

        return encoder.encode(targetBytes);
    }

    /**
     * Base 64로 인코딩된 문자열을 디코드한다.
     * @param encodedString
     * @return
     */
    @Override
    public byte[] decodeBytesWithBase64(byte[] encodedString) {
        Base64.Decoder decoder = Base64.getDecoder();

        return decoder.decode(encodedString);
    }

    /**
     * MD5로 문자열을 인코딩 한다.
     * @param targetString
     * @return
     * @throws NoSuchAlgorithmException
     */
    @Override
    public String encodeStringWithMD5(String targetString) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(targetString.getBytes());

        byte[] bytes = messageDigest.digest();
        StringBuffer sb = new StringBuffer();

        for(byte b : bytes) {
            sb.append(Integer.toHexString(b & 0xff));
        }
        return sb.toString();
    }

    /**
     * SHA256으로 문자열을 인코딩한다.
     * @param targetString
     * @return
     * @throws NoSuchAlgorithmException
     */
    @Override
    public String encodeStringWithSHA256(String targetString) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(targetString.getBytes());

        byte[] bytes = messageDigest.digest();
        StringBuffer sb = new StringBuffer();

        for(byte b : bytes) {
            sb.append(Integer.toHexString(b & 0xff));
        }
        return sb.toString();
    }
}
