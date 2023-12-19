package comsinor.websocket.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisConnectionConfig {
    private final StringRedisTemplate stringRedisTemplate;

    public RedisConnectionConfig(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

}
