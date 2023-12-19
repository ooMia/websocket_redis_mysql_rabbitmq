package com.sinor.redis;

import com.sinor.redis.model.RedisStringsEntity;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    private final RedisStringsRepository redisStringsRepository;

    @Autowired
    public RedisService(RedisStringsRepository redisStringsRepository) {
        this.redisStringsRepository = redisStringsRepository;
    }

    public RedisStringsDto<RedisStringsEntity> saveOneByKeyValue(String key, String value) {
        RedisStringsEntity entity = new RedisStringsEntity(key, value);
        redisStringsRepository.save(entity);
        return new RedisStringsDto<>(List.of(entity));
    }

    public RedisStringsDto<RedisStringsEntity> updateOneByKeyValue(String key, String value)
            throws NoSuchElementException {
        redisStringsRepository.findById(key).orElseThrow();
        RedisStringsEntity entity = redisStringsRepository.update(new RedisStringsEntity(key, value));
        return new RedisStringsDto<>(List.of(entity));
    }

    public RedisStringsDto<RedisStringsEntity> findOneByKey(String key) throws NoSuchElementException {
        RedisStringsEntity found = redisStringsRepository.findById(key).orElseThrow();
        return new RedisStringsDto<>(List.of(found));
    }

    public RedisStringsDto<Long> countKeys() {
        long count = redisStringsRepository.count();
        return new RedisStringsDto<>(List.of(count));
    }

    public RedisStringsDto<String> getAllKeys() {
        return new RedisStringsDto<>(redisStringsRepository.getAllKeys());
    }

    public RedisStringsDto<RedisStringsEntity> deleteOne(String key) throws NoSuchElementException {
        RedisStringsEntity target = redisStringsRepository.findById(key).orElseThrow();
        redisStringsRepository.deleteById(key);
        if (redisStringsRepository.existsById(key)) {
            throw new InternalError();
        }
        return new RedisStringsDto<>(List.of(target));
    }
}
