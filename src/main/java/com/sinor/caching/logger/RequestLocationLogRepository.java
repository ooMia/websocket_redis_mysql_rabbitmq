package com.sinor.caching.logger;

import com.sinor.caching.logger.model.FromWhereDidWhatLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public interface RequestLocationLogRepository extends CrudRepository<FromWhereDidWhatLog, Long> {
}
