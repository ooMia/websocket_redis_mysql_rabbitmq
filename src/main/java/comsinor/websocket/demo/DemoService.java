package comsinor.websocket.demo;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	private final DemoRepository demoRepository;

	@Autowired
	public DemoService(DemoRepository demoRepository) {
		this.demoRepository = demoRepository;
	}

	public DemoUserDto getFirstUser() throws NoSuchElementException {
		// Save a new user
		demoRepository.save(new DemoUser(1L, "a"));

		// Find a user by ID
		Optional<DemoUser> user = demoRepository.findById(1L);
		return new DemoUserDto(user.orElseThrow().id, user.get().name);
	}
}
