package com.sinor.backend.websocket.service;

import com.sinor.backend.websocket.model.dto.request.VoteRequestDto;
import com.sinor.backend.websocket.model.dto.response.VoteResponseDto;
import com.sinor.backend.websocket.model.entity.Vote;
import com.sinor.backend.websocket.repository.BoardRepository;
import com.sinor.backend.websocket.repository.VoteRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteLogService {
    private final VoteRepository voteRepository;
    private final BoardRepository boardRepository;

    @Autowired
    public VoteLogService(VoteRepository voteRepository, BoardRepository boardRepository) {
        this.voteRepository = voteRepository;
        this.boardRepository = boardRepository;
    }

    public VoteResponseDto createObject(VoteRequestDto requestDto) throws NoSuchElementException {
        Vote vote = Vote.builder()
                .title(requestDto.title())
                .boardId(requestDto.boardId())
                .build();
        return new VoteResponseDto(voteRepository.saveAndFlush(vote).getId());
    }
}