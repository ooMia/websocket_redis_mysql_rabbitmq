package com.sinor.backend.websocket.controller;

import com.sinor.backend.websocket.common.AbstractCrudController;
import com.sinor.backend.websocket.model.dto.VoteResponseDto;
import com.sinor.backend.websocket.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/vote")
public class VoteController implements AbstractCrudController<VoteResponseDto> {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @Override
    public VoteResponseDto createObject() {
        return null;
    }

    @Override
    public VoteResponseDto readObject() {
        return null;
    }

    @Override
    public VoteResponseDto updateObject() {
        return null;
    }

    @Override
    public VoteResponseDto deleteObject() {
        return null;
    }
}
