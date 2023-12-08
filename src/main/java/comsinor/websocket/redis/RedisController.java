package comsinor.websocket.redis;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

	private final RedisService redisService;

	@Autowired
	public RedisController(RedisService redisService) {
		this.redisService = redisService;
	}

	@PostMapping(path = "/redis/saveone")
	@ResponseBody
	public RedisStringsDto saveOne(
		@RequestBody Map<String, Optional<String>> body
	) throws NoSuchElementException {
		String key = body.get("key").orElseThrow();
		String value = body.get("value").orElseThrow();
		return redisService.saveByKeyValue(key, value);
	}

	@GetMapping(path = "/redis/readone/{key}")
	@ResponseBody
	public RedisStringsDto readOne(
		@PathVariable String key
	) throws NoSuchElementException {
		return redisService.getValueByKey(key);
	}

}
