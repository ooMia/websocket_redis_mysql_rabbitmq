package comsinor.websocket.logger.model;

import java.time.LocalDateTime;

public record LogDto(
	LocalDateTime createdAt,
	LocalDateTime currentAt
) {
}
