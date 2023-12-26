package com.sinor.backend.websocket.model.dto.response;

import com.sinor.backend.websocket.model.entity.Vote;
import java.util.List;
import lombok.Builder;

@Builder
public record BoardResponseDto(
        Long id,
        List<Vote> votes
) {

}
