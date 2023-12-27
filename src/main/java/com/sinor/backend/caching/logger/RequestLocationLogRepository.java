package com.sinor.backend.caching.logger;

import com.sinor.backend.caching.logger.model.FromWhereDidWhatLog;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RequestLocationLogRepository extends CrudRepository<FromWhereDidWhatLog, Long> {
}
