package com.sinor.backend.caching.demo;

import com.sinor.backend.caching.demo.model.DemoResponse;
import com.sinor.backend.caching.demo.model.DemoResponseDto;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private final DemoRepository demoRepository;

    @Autowired
    public DemoService(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    public DemoResponseDto getFirstUser() throws NoSuchElementException {
        // Save a new user
        DemoResponse entity = DemoResponse.builder()
                .id("key")
                .name("asd")
                .profile("asda")
                .build();
        demoRepository.save(entity);

        // Find a user by ID
        DemoResponse response = demoRepository.findById("key").orElseThrow();
        return new DemoResponseDto(response.getId(), response.toString());
    }
}
