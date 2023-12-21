package com.sinor.backend.redis;

public record RedisStringsDto<T>(
        Iterable<T> data
) {

}

