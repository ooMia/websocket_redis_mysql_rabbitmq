package comsinor.websocket.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisConnectionConfig {
    private final StringRedisTemplate template;

    public RedisConnectionConfig(StringRedisTemplate template) {
        this.template = template;
    }

}
