package com.sinor.caching.cache.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinor.redis.RedisService;
import com.sinor.redis.RedisStringsRepository;
import com.sinor.redis.model.RedisStringsEntity;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    private static final String serverHostPort = "localhost:8080";

    private final RedisStringsRepository redisStringsRepository;
    private final RedisService redisService;
    private final ObjectMapper objectMapper;


    @Autowired
    public CacheService(RedisStringsRepository redisStringsRepository, RedisService redisService,
                        ObjectMapper objectMapper) {
        this.redisStringsRepository = redisStringsRepository;
        this.redisService = redisService;
        this.objectMapper = objectMapper;
    }

    public HttpResponse<String> sendRequest(String pathQueryString, String body, HttpServletRequest request)
            throws IOException, InterruptedException {

        URI uri = URI.create(MessageFormat.format("{0}://{1}{2}", "http", serverHostPort, pathQueryString));

        HttpRequest httpRequest = convert(uri, request, body).build();

        HttpResponse<String> httpResponse;
        try (HttpClient client = HttpClient.newHttpClient()) {
            httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        }

        return httpResponse;
    }


    private HttpRequest.Builder convert(URI uri, HttpServletRequest servletRequest, String body) {
        HttpRequest.Builder httpRequestBuilder = HttpRequest.newBuilder(uri);
        httpRequestBuilder.method(servletRequest.getMethod(),
                HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8));

        List<String> restrictedHeader = List.of("content-length", "host", "connection");

        Collections.list(servletRequest.getHeaderNames()).forEach(headerName -> {
            if (!restrictedHeader.contains(headerName)) {
                Collections.list(servletRequest.getHeaders(headerName))
                        .forEach(headerValue -> httpRequestBuilder.header(headerName, headerValue));
            }
        });

        return httpRequestBuilder;
    }

    public String storeCache(
            String cacheKey,
            HttpResponse<String> response
    ) throws NoSuchElementException, JsonProcessingException {
//        RedisStrings entity = new RedisStrings(cacheKey,
//                objectMapper.writeValueAsString(new HttpResponseImpl(response)));
        RedisStringsEntity entity = new RedisStringsEntity(cacheKey, response.body());
        redisStringsRepository.save(entity);
        return getCache(cacheKey);
    }

    public String getCache(
            String cacheKey
    ) throws NoSuchElementException {
        RedisStringsEntity entity = redisStringsRepository.findById(cacheKey).orElseThrow();
//        try {
//            return objectMapper.readValue(entity.getValue(), HttpResponseImpl.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        // TODO: HttpResponse 빌드해서 반환하기
        return entity.getValue();
    }
}
