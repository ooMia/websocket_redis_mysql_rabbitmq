package com.sinor.backend.websocket.service;

import com.sinor.backend.websocket.model.dto.request.BoardRequestDto;
import com.sinor.backend.websocket.model.dto.response.BoardResponseDto;
import com.sinor.backend.websocket.model.entity.Board;
import com.sinor.backend.websocket.repository.BoardRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponseDto createObject(BoardRequestDto requestDto) {
        Board board = boardRepository.save(Board.builder().build());
        return BoardResponseDto.builder().id(board.getId()).build();
    }

    public BoardResponseDto readObjcect(Long id) throws NoSuchElementException {
        Board board = boardRepository.findById(id).orElseThrow();
        return BoardResponseDto.builder().id(board.getId()).votes(board.getVotes().stream().toList()).build();
    }
}
