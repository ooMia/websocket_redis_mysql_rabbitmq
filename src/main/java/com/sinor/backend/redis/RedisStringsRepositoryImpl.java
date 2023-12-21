package com.sinor.backend.redis;

import com.sinor.backend.redis.model.RedisStrings;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public class RedisStringsRepositoryImpl implements RedisStringsRepository {
    private final StringRedisTemplate stringRedisTemplate;
    private long count = 0;

    @Autowired
    public RedisStringsRepositoryImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        try (Cursor<String> cursor = stringRedisTemplate.scan(ScanOptions.scanOptions().match("*").build())) {
            this.count += cursor.stream().count();
        }
    }

    @Override
    @NonNull
    public <S extends RedisStrings> S save(S entity) throws NoSuchElementException {
        String key = entity.getKey();
        String value = entity.getValue();
        stringRedisTemplate.opsForValue().setIfAbsent(key, value);
        ++count;
        return (S) findById(key).orElseThrow();
    }

    @Override
    @NonNull
    public <S extends RedisStrings> Iterable<S> saveAll(Iterable<S> entities) {
        entities.forEach(this::save);
        return entities;
    }

    @NonNull
    public RedisStrings update(RedisStrings entity) throws NoSuchElementException {
        String key = entity.getKey();
        String value = entity.getValue();
        stringRedisTemplate.opsForValue().setIfPresent(key, value);
        return findById(key).orElseThrow();
    }

    @Override
    @NonNull
    public Optional<RedisStrings> findById(@NonNull String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        if (value != null) {
            return Optional.of(new RedisStrings(key, value));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NonNull String key) {
        return findById(key).isPresent();
    }

    @Override
    @NonNull
    public Iterable<RedisStrings> findAll() {
        List<RedisStrings> res = new ArrayList<>();
        getAllKeys().forEach(key ->
                findById(key).ifPresent(res::add)
        );
        return res;
    }

    @Override
    @NonNull
    public Iterable<RedisStrings> findAllById(@NonNull Iterable<String> keys) {
        List<RedisStrings> res = new ArrayList<>();
        keys.forEach(key -> findById(key).ifPresent(res::add));
        return res;
    }

    @Override
    public long count() {
        return this.count;
    }

    @Override
    public void deleteById(@NonNull String key) throws NoSuchElementException {
        if (Boolean.FALSE.equals(stringRedisTemplate.unlink(key))) {
            throw new NoSuchElementException();
        }
        --count;
    }

    @Override
    public void delete(RedisStrings entity) {
        if (Boolean.FALSE.equals(stringRedisTemplate.unlink(entity.getKey()))) {
            throw new NoSuchElementException();
        }
        --count;
    }

    @Override
    public void deleteAllById(@NonNull Iterable<? extends String> keys) {
        keys.forEach(this::deleteById);
    }

    @Override
    public void deleteAll(Iterable<? extends RedisStrings> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        deleteAllById(getAllKeys());
    }

    @Override
    public Iterable<String> getAllKeys() {
        List<String> keys = new ArrayList<>();
        try (Cursor<String> cursor = stringRedisTemplate.scan(ScanOptions.scanOptions().match("*").build())) {
            cursor.forEachRemaining(keys::add);
        }
        return keys;
    }

}
