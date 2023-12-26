package com.sinor.backend.websocket.controller;

import com.sinor.backend.websocket.common.AbstractCrudController;
import com.sinor.backend.websocket.model.dto.request.MemberRequestDto;
import com.sinor.backend.websocket.model.dto.response.MemberResponseDto;
import com.sinor.backend.websocket.service.MemberService;
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
@RequestMapping(path = "/member")
public class VoteLogController implements AbstractCrudController<MemberResponseDto, MemberRequestDto> {

    private final MemberService memberService;

    @Autowired
    public VoteLogController(MemberService memberService) {
        this.memberService = memberService;
    }


    @Override
    @GetMapping
    public ResponseEntity<MemberResponseDto> readObject(
            @RequestParam(value = "id") Long id
    ) {
        return ResponseEntity.ok(new MemberResponseDto(0L));
    }

    @Override
    @PostMapping
    public ResponseEntity<MemberResponseDto> createObject(
            @RequestBody MemberRequestDto requestDto
    ) {
        return ResponseEntity.ok(new MemberResponseDto(0L));
    }

    @Override
    @PutMapping
    public ResponseEntity<MemberResponseDto> updateObject(
            @RequestBody MemberRequestDto requestDto
    ) {
        return ResponseEntity.ok(new MemberResponseDto(0L));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<MemberResponseDto> deleteObject(
            @RequestBody MemberRequestDto requestDto
    ) {
        return ResponseEntity.ok(new MemberResponseDto(0L));
    }
}
