package com.sinor.backend.websocket.model.dto.request;

import lombok.Builder;

@Builder
public record VoteRequestDto(
        Long boardId,
        String title
) {
}
