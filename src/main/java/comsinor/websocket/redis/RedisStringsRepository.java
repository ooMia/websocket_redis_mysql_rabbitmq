package comsinor.websocket.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RedisStringsRepository extends CrudRepository<RedisStrings, String> {
    Iterable<String> getAllKeys();

    RedisStrings update(RedisStrings redisStrings);

}
