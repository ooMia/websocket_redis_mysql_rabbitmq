package com.sinor.backend.websocket.model.dto.response;


import lombok.Builder;

@Builder

public record VoteLogResponseDto(
        Long id,
        Long voteCandidateId,
        Long memberId
) {

}
