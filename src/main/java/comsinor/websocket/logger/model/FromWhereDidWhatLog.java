package comsinor.websocket.logger.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class FromWhereDidWhatLog extends BaseLog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected Long id;

	protected String scheme;

	public FromWhereDidWhatLog(LogDto logDto) {
		super();
		this.scheme = logDto.request().getScheme();
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s", id, createdAt, currentAt, scheme);
		// return STR. "\{id} \{createdAt} \{currentAt} ";
	}
}
