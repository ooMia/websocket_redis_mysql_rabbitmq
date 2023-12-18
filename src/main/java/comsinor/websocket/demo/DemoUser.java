package comsinor.websocket.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
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
