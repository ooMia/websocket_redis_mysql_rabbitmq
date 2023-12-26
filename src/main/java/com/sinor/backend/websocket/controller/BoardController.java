package com.sinor.backend.websocket.controller;

import com.sinor.backend.websocket.common.AbstractCrudController;
import com.sinor.backend.websocket.model.dto.BoardResponseDto;
import com.sinor.backend.websocket.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/board")
public class BoardController implements AbstractCrudController<BoardResponseDto> {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @Override
    public BoardResponseDto createObject() {
        return null;
    }

    @Override
    public BoardResponseDto readObject() {
        return null;
    }

    @Override
    public BoardResponseDto updateObject() {
        return null;
    }

    @Override
    public BoardResponseDto deleteObject() {
        return null;
    }
}
