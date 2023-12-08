package comsinor.websocket.redis;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RedisStrings {
	@Id
	private String key;
	private String value;

	public RedisStrings(String key, String value) {
		this.key = key;
		this.value = value;
	}
}
