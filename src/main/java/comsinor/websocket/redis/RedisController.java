package comsinor.websocket.redis;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/redis")
public class RedisController {

	private final RedisService redisService;

	@Autowired
	public RedisController(RedisService redisService) {
		this.redisService = redisService;
	}

	// CREATE
	@PostMapping(path = "/sample")
	@ResponseBody
	public RedisStringsDto<RedisStrings> saveOne(
		@RequestBody Map<String, Optional<String>> body
	) throws NoSuchElementException {
		String key = body.get("key").orElseThrow();
		String value = body.get("value").orElseThrow();
		return redisService.saveOneByKeyValue(key, value);
	}

	// READ
	@GetMapping(path = "/number")
	@ResponseBody
	public RedisStringsDto<Long> countAll() {
		return redisService.countKeys();
	}

	@GetMapping(path = "/sample")
	@ResponseBody
	public RedisStringsDto<RedisStrings> readOne(
		@RequestParam(name = "key") String key
	) throws NoSuchElementException {
		return redisService.findOneByKey(key);
	}

	@GetMapping(path = "/sample/keys")
	@ResponseBody
	public RedisStringsDto<String> getAllKeys() {
		return redisService.getAllKeys();
	}

	// UPDATE
	@PutMapping(path = "/sample")
	@ResponseBody
	public RedisStringsDto<RedisStrings> updateOne(
		@RequestBody Map<String, Optional<String>> body
	) throws NoSuchElementException {
		String key = body.get("key").orElseThrow();
		String value = body.get("value").orElseThrow();
		return redisService.saveOneByKeyValue(key, value);
	}

	// DELETE
	@DeleteMapping(path = "/sample")
	@ResponseBody
	public RedisStringsDto<RedisStrings> deleteOne(
		@RequestParam(name = "key") String key
	) throws NoSuchElementException {
		return redisService.deleteOne(key);
	}
}
