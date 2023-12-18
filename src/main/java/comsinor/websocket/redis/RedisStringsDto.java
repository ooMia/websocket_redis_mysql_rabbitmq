package comsinor.websocket.redis;

public record RedisStringsDto<T>(
        Iterable<T> data
) {

}

