package comsinor.websocket.redis;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisStringsRepositoryImpl implements RedisStringsRepository{

	private final StringRedisTemplate stringRedisTemplate;

	@Autowired
	public RedisStringsRepositoryImpl(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
	}

	@Override
	public <S extends RedisStrings> S save(S entity) {
		String key = entity.getKey();
		String value = entity.getValue();
		stringRedisTemplate.opsForValue().set(key, value);
		value = stringRedisTemplate.opsForValue().get(key);
		return (S)new RedisStrings(key, value);
	}

	@Override
	public <S extends RedisStrings> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public Optional<RedisStrings> findById(String s) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(String s) {
		return false;
	}

	@Override
	public Iterable<RedisStrings> findAll() {
		return null;
	}

	@Override
	public Iterable<RedisStrings> findAllById(Iterable<String> strings) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(String s) {

	}

	@Override
	public void delete(RedisStrings entity) {

	}

	@Override
	public void deleteAllById(Iterable<? extends String> strings) {

	}

	@Override
	public void deleteAll(Iterable<? extends RedisStrings> entities) {

	}

	@Override
	public void deleteAll() {

	}
}
