package com.nexters.javaencodingalgorithm.services;

import java.security.NoSuchAlgorithmException;

public interface MainService {

    byte[] encodeStringWithBase64(String targetString);

    byte[] decodeBytesWithBase64(byte[] encodedString);

    String encodeStringWithMD5(String targetString) throws NoSuchAlgorithmException;

    String encodeStringWithSHA256(String targetString) throws NoSuchAlgorithmException;
}
