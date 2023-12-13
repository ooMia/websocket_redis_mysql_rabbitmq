package comsinor.websocket.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comsinor.websocket.logger.model.FromWhereDidWhatLog;
import comsinor.websocket.logger.model.LogDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoggerService {
	private final RequestLocationLogRepository loggerRepository;

	@Autowired
	public LoggerService(RequestLocationLogRepository loggerRepository) {
		this.loggerRepository = loggerRepository;
	}

	public void saveRequest(LogDto logDto) {
		FromWhereDidWhatLog entity = new FromWhereDidWhatLog(logDto);
		loggerRepository.save(entity);
		log.info(entity.toString());
	}
}
