package com.sinor.backend.websocket.service;

import com.sinor.backend.websocket.common.AbstractCrudService;
import com.sinor.backend.websocket.model.dto.request.BoardRequestDto;
import com.sinor.backend.websocket.model.dto.response.BoardResponseDto;
import com.sinor.backend.websocket.model.entity.board.Board;
import com.sinor.backend.websocket.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService extends AbstractCrudService<BoardResponseDto, BoardRequestDto, BoardRepository, Board, Long> {


    private final VoteService voteService;

    @Autowired
    public BoardService(BoardRepository boardRepository, VoteService voteService) {
        super(boardRepository);
        this.voteService = voteService;
    }

    @Override
    protected Board fromRequestDtoToEntity(BoardRequestDto boardRequestDto) {
        return Board.builder().build();
    }

    @Override
    protected BoardResponseDto fromEntitytoResponseDto(Board entity) {
        return BoardResponseDto.builder()
                .id(entity.getId())
                .votes(entity.getVotes() != null
                        ? entity.getVotes().stream().map(voteService::fromEntitytoResponseDto)
                        .toList() : null)
                .build();
    }

    @Override
    public BoardResponseDto updateObject(Long id, BoardRequestDto boardRequestDto) {
        return null;
    }
}
