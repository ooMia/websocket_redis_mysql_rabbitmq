package comsinor.websocket.logger.filter;

import comsinor.websocket.logger.LoggerService;
import comsinor.websocket.logger.model.LogDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
@WebFilter(filterName = "RequestCachingFilter", urlPatterns = "/*")
@Slf4j
public class RequestCachingFilter extends OncePerRequestFilter {

    private final LoggerService loggerService;

    @Autowired
    public RequestCachingFilter(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        CachedHttpServletRequest cachedHttpServletRequest = new CachedHttpServletRequest(request);
        filterChain.doFilter(cachedHttpServletRequest, response);
        loggerService.saveResponse(new LogDto(request, response));
    }
}
