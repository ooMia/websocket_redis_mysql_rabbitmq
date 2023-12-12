package comsinor.websocket.logger.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "request_location_log")
@NoArgsConstructor
public class RequestLocationLog extends BaseLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Override
	public String toString() {
		return String.format("%s %s %s", id, createdAt, currentAt);
		// return STR. "\{id} \{createdAt} \{currentAt} ";
	}
}
