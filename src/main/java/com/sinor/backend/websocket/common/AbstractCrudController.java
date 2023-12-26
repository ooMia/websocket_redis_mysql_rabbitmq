package com.sinor.backend.websocket.common;

public interface AbstractCrudController<ResponseDto> {
    ResponseDto createObject();

    ResponseDto readObject();

    ResponseDto updateObject();

    ResponseDto deleteObject();
}
