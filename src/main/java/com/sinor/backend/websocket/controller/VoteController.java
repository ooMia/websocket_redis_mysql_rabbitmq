package com.sinor.backend.websocket.controller;

import com.sinor.backend.websocket.common.AbstractCrudController;
import com.sinor.backend.websocket.model.dto.request.VoteRequestDto;
import com.sinor.backend.websocket.model.dto.response.VoteResponseDto;
import com.sinor.backend.websocket.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/vote")
public class VoteController implements AbstractCrudController<VoteResponseDto, VoteRequestDto> {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }


    @Override
    @GetMapping
    public ResponseEntity<VoteResponseDto> readObject(
            @RequestParam(value = "id") Long id
    ) {
        return ResponseEntity.ok(new VoteResponseDto(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<VoteResponseDto> createObject(
            @RequestBody VoteRequestDto requestDto
    ) {
        return ResponseEntity.ok(voteService.createObject(requestDto));
    }

    @Override
    @PutMapping
    public ResponseEntity<VoteResponseDto> updateObject(
            @RequestBody VoteRequestDto responseDto
    ) {
        return ResponseEntity.ok(new VoteResponseDto(0L));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<VoteResponseDto> deleteObject(
            @RequestBody VoteRequestDto responseDto
    ) {
        return ResponseEntity.ok(new VoteResponseDto(0L));
    }
}
