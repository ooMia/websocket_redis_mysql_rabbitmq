package com.sinor.backend.caching.logger;

import com.sinor.backend.caching.logger.model.FromWhereDidWhatLog;
import com.sinor.backend.caching.logger.model.LogDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoggerService {
    private final RequestLocationLogRepository loggerRepository;

    @Autowired
    public LoggerService(RequestLocationLogRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    public void saveResponse(LogDto logDto) {
        FromWhereDidWhatLog entity = new FromWhereDidWhatLog(logDto);
        loggerRepository.save(entity);
        log.info(entity.toString());
    }
}
