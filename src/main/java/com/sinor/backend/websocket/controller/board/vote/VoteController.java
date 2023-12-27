package com.sinor.backend.websocket.controller.board.vote;

import com.sinor.backend.websocket.common.BaseCrudController;
import com.sinor.backend.websocket.model.dto.request.VoteRequestDto;
import com.sinor.backend.websocket.model.dto.response.VoteResponseDto;
import com.sinor.backend.websocket.service.VoteCandidateService;
import com.sinor.backend.websocket.service.VoteService;
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
@RequestMapping(path = "/vote")
public class VoteController implements BaseCrudController<VoteResponseDto, VoteRequestDto, Long> {

    private final VoteService voteService;
    private final VoteCandidateService voteCandidateService;


    @Autowired
    public VoteController(
            VoteService voteService, VoteCandidateService voteCandidateService) {
        this.voteService = voteService;
        this.voteCandidateService = voteCandidateService;
    }


    @Override
    @PostMapping
    public ResponseEntity<VoteResponseDto> createObject(
            @RequestBody VoteRequestDto requestDto
    ) {
        return ResponseEntity.ok(voteService.createObject(requestDto));
    }

    @Override
    @GetMapping("/{vote_id}")
    public ResponseEntity<VoteResponseDto> readObject(
            @PathVariable(name = "vote_id") Long id
    ) {
        return ResponseEntity.ok(voteService.readObject(id));
    }

    @Override
    @PutMapping("/{vote_id}")
    public ResponseEntity<VoteResponseDto> updateObject(
            @PathVariable(name = "vote_id") Long id,
            VoteRequestDto voteRequestDto
    ) {
        return ResponseEntity.ok(voteService.updateObject(id, voteRequestDto));
    }

    @Override
    @DeleteMapping("/{vote_id}")
    public ResponseEntity<VoteResponseDto> deleteObject(
            @PathVariable(name = "vote_id") Long id
    ) {
        return ResponseEntity.ok(voteService.deleteObject(id));
    }

}
