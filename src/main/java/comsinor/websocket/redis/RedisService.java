package comsinor.websocket.redis;

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

	public RedisStringsDto saveByKeyValue(String key, String value) {
		redisStringsRepository.save(new RedisStrings(key, value));
		return new RedisStringsDto(key, value);
	}

	public RedisStringsDto getValueByKey(String key) throws NoSuchElementException {
		RedisStrings found = redisStringsRepository.findById(key).orElseThrow();
		return new RedisStringsDto(key, found.getValue());
	}

}
