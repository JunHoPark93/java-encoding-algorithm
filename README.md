# java-encoding-algorithm

### Encoding project for url shortener using Java

## 1. Base64
Binary data를 text로 다룰 때 쓰는 변환이다.

## 2. MD5
- 128 bit 해시 값 이용
MessageDigest을 이용한다. 문서에 따르면 MessageDigest는 SHA-1, SHA-256 등의 알고리즘을 사용하기 위해 사용되는 것이며 one-way 해시 함수이다. 결과값으로 고정된 길이의 해시 값을 반환한다.

```java
MessageDigest messageDigest = MessageDigest.getInstance("MD5");
messageDigest.update(targetString.getBytes());

byte[] bytes = messageDigest.digest();
StringBuffer sb = new StringBuffer();

for(byte b : bytes) {
    sb.append(Integer.toHexString(b & 0xff).toString());
}
return sb.toString();
```
MD5를 사용하려고 MessageDigest를 선언한다. 문자열 연산에 효율적인 StringBuffer를 사용하여 바이트 연산을 진행한다. Integer를 toHexString을 시켜주는데 비트 마스크(0xff)를 씌워준다. 결국 마지막 8bit만 남고 그 이상은 잘린다.
문자열을 줄이는데는 이 역시 적당하지 않다. 

## 3. ID Generate 방식

문자열을 그대로 인코딩 하는 방식이 효과적으로 줄이지 못하는 듯 하다. 서버에서 고유한 번호를 부여하여 모듈러 연산을 통해 해시 값을 부여하는 방법을 생각해보자.

