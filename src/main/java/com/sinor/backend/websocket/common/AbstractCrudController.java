package com.sinor.backend.websocket.common;

import org.springframework.http.ResponseEntity;

public interface AbstractCrudController<ResponseDto, RequestDto> {

    ResponseEntity<ResponseDto> readObject(Long id);

    ResponseEntity<ResponseDto> createObject(RequestDto requestDto);

    ResponseEntity<ResponseDto> updateObject(RequestDto requestDto);

    ResponseEntity<ResponseDto> deleteObject(RequestDto requestDto);
}
