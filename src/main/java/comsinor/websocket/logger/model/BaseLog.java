package comsinor.websocket.logger.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@CreationTimestamp
	LocalDateTime createdAt;

	@CurrentTimestamp
	LocalDateTime currentAt;
}