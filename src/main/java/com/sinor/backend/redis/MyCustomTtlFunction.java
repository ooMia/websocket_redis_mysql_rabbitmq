package com.sinor.backend.redis;

import jakarta.annotation.Nullable;
import java.time.Duration;
import org.springframework.data.redis.cache.RedisCacheWriter.TtlFunction;
import org.springframework.lang.NonNull;

enum MyCustomTtlFunction implements TtlFunction {

    INSTANCE;

    @Override
    @NonNull
    public Duration getTimeToLive(@NonNull Object key, @Nullable Object value) {
        // compute a TTL expiration timeout (Duration) based on the cache entry key and/or value
        return Duration.ofSeconds(6);
    }
}