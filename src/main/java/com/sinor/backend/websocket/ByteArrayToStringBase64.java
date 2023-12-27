package com.sinor.backend.websocket;

import java.util.Base64;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ByteArrayToStringBase64 implements Converter<byte[], String> {

    @Override
    public String convert(byte[] source) {
        byte[] decodedString = Base64.getDecoder().decode(source);
        return new String(decodedString);
    }
}