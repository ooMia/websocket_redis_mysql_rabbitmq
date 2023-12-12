package comsinor.websocket.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comsinor.websocket.logger.model.RequestLocationLog;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoggerService {
	private final RequestLocationLogRepository loggerRepository;

	@Autowired
	public LoggerService(RequestLocationLogRepository loggerRepository) {
		this.loggerRepository = loggerRepository;
	}

	public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
		RequestLocationLog entity = new RequestLocationLog();
		// TODO: use LogDto(should rename) with req/res
		loggerRepository.save(entity);
		log.info(entity.toString());
	}
}
