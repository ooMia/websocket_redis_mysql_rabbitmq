package com.sinor.backend.websocket.service;

import com.sinor.backend.websocket.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    private final VoteRepository voteRepository;

    @Autowired

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }
}