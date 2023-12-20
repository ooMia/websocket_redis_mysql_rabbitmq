package com.sinor.backend.caching.cache.model;

import java.net.http.HttpResponse;
import lombok.Getter;

@Getter
public class HttpResponseImpl {

    public final String httpResponse;

    public HttpResponseImpl(HttpResponse<String> httpResponse) {
        this.httpResponse = httpResponse.body();
    }
}
