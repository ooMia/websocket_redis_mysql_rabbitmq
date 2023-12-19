package com.sinor.redis;

import com.sinor.redis.model.RedisStringsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RedisStringsRepository extends CrudRepository<RedisStringsEntity, String> {
    Iterable<String> getAllKeys();

    RedisStringsEntity update(RedisStringsEntity redisStringsEntity);

}
