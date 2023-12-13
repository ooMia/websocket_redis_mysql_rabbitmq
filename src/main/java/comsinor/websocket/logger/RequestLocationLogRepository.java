package comsinor.websocket.logger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import comsinor.websocket.logger.model.FromWhereDidWhatLog;

@Repository
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public interface RequestLocationLogRepository extends CrudRepository<FromWhereDidWhatLog, Long> {
}
