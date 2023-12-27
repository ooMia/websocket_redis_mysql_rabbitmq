package com.sinor.backend.websocket.common;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public abstract class AbstractResponseDto<Entity> extends ResponseEntity<Entity> {
    public AbstractResponseDto() {
        super(HttpStatusCode.valueOf(204));
    }
}
