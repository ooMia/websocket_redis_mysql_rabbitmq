package com.sinor.redis;

public record RedisStringsDto<T>(
        Iterable<T> data
) {

}

