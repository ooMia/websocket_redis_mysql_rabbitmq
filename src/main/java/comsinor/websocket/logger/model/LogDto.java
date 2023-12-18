package comsinor.websocket.logger.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public record LogDto(
        HttpServletRequest request,
        HttpServletResponse response
) {
}
