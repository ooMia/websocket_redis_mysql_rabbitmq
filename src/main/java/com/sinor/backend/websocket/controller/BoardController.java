package com.sinor.backend.websocket.controller;

import com.sinor.backend.websocket.common.AbstractCrudController;
import com.sinor.backend.websocket.model.dto.request.BoardRequestDto;
import com.sinor.backend.websocket.model.dto.response.BoardResponseDto;
import com.sinor.backend.websocket.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/board")
public class BoardController implements AbstractCrudController<BoardResponseDto, BoardRequestDto> {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @Override
    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDto> readObject(
            @PathVariable(name = "id") Long id
    ) {
        return ResponseEntity.ok(boardService.readObjcect(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<BoardResponseDto> createObject(
            @RequestBody BoardRequestDto requestDto
    ) {
        return ResponseEntity.ok(boardService.createObject(requestDto));
    }

    @Override
    @PutMapping
    public ResponseEntity<BoardResponseDto> updateObject(
            @RequestBody BoardRequestDto requestDto
    ) {
        return ResponseEntity.ok(null);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<BoardResponseDto> deleteObject(
            @RequestBody BoardRequestDto requestDto
    ) {
        return ResponseEntity.ok(null);
    }
}
