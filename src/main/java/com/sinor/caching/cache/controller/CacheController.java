package com.sinor.caching.cache.controller;

import com.sinor.caching.cache.service.CacheService;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.NoSuchElementException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/echo")
@Log4j2
public class CacheController {

    private final CacheService cacheService;

    @Autowired
    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @RequestMapping(path = {
            "/{path1}/{path2}/{path3}/{path4}",
            "/{path1}/{path2}/{path3}",
            "/{path1}/{path2}",
            "/{path1}"
    }, method = RequestMethod.GET)
    @ResponseBody
    public String echoGetRequest(
            @PathVariable Map<String, String> pathMap,
            HttpServletRequest request
    ) {
        String pathQueryString = getPathQueryString(pathMap, request);
        String cacheKey = request.getMethod() + pathQueryString;
        try {
            return cacheService.getCache(cacheKey);
        } catch (NoSuchElementException e) {
            log.info("Not Found");
        }

        try {
            HttpResponse<String> response = cacheService.sendRequest(
                    pathQueryString,
                    "",
                    request);
            log.info("success");
            return cacheService.storeCache(cacheKey, response);
        } catch (IOException | InterruptedException e) {
            log.info("failed");
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(path = {
            "/{path1}/{path2}/{path3}/{path4}",
            "/{path1}/{path2}/{path3}",
            "/{path1}/{path2}",
            "/{path1}"
    })
    @ResponseBody
    public String echoRequest(
            @PathVariable Map<String, String> pathMap,
            @RequestBody String body,
            HttpServletRequest request
    ) {
        String pathQueryString = getPathQueryString(pathMap, request);
        String cacheKey = request.getMethod() + pathQueryString;
        try {
            return cacheService.getCache(cacheKey);
        } catch (NoSuchElementException e) {
            log.info("Not Found");
        }

        try {
            HttpResponse<String> response = cacheService.sendRequest(
                    pathQueryString,
                    body,
                    request);
            log.info("success");
            return cacheService.storeCache(cacheKey, response);
        } catch (IOException | InterruptedException e) {
            log.info("failed");
            throw new RuntimeException(e);
        }
    }

    private String getPathQueryString(Map<String, String> pathMap, HttpServletRequest request) {
        StringBuilder path = new StringBuilder();
        for (int i = 1; i < 5; ++i) {
            String key = "path" + i;
            String value = pathMap.get(key);
            if (value != null) {
                path.append("/").append(value);
            }
        }

        String queryString = request.getQueryString();
        if (queryString != null) {
            path.append("?").append(queryString);
        }
        return String.valueOf(path);
    }

}
