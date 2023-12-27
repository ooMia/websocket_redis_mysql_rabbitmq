package com.sinor.backend.websocket.model.dto.response;

import java.util.List;
import lombok.Builder;

@Builder
public record VoteCandidateResponseDto(
        Long id,
        List<VoteLogResponseDto> voteLogs,
        Integer count
) {
}
