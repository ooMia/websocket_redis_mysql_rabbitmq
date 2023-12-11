package comsinor.websocket.redis;

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

	public RedisStringsDto<RedisStrings> saveOneByKeyValue(String key, String value) {
		RedisStrings entity = new RedisStrings(key, value);
		redisStringsRepository.save(entity);
		return new RedisStringsDto<>(List.of(entity));
	}

	public RedisStringsDto<RedisStrings> updateOneByKeyValue(String key, String value) throws NoSuchElementException {
		redisStringsRepository.findById(key).orElseThrow();
		RedisStrings entity = redisStringsRepository.update(new RedisStrings(key, value));
		return new RedisStringsDto<>(List.of(entity));
	}

	public RedisStringsDto<RedisStrings> findOneByKey(String key) throws NoSuchElementException {
		RedisStrings found = redisStringsRepository.findById(key).orElseThrow();
		return new RedisStringsDto<>(List.of(found));
	}

	public RedisStringsDto<Long> countKeys() {
		long count = redisStringsRepository.count();
		return new RedisStringsDto<>(List.of(count));
	}

	public RedisStringsDto<String> getAllKeys() {
		return new RedisStringsDto<>(redisStringsRepository.getAllKeys());
	}

	public RedisStringsDto<RedisStrings> deleteOne(String key) throws NoSuchElementException {
		RedisStrings target = redisStringsRepository.findById(key).orElseThrow();
		redisStringsRepository.deleteById(key);
		if (redisStringsRepository.existsById(key))
			throw new InternalError();
		return new RedisStringsDto<>(List.of(target));
	}
}
