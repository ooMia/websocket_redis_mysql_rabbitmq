package comsinor.websocket.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "demo_user")
@NoArgsConstructor
class DemoUser {
	@Id
	Long id;
	String name;
	String profile;

	public DemoUser(Long id, String name) {
		this.id = id;
		this.name = name;
		this.profile = "https://cdn.aws/profile.png";
	}
}
