package com.sinor.backend.caching.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@Getter
public class DemoResponse {
    @Id
    private String id;
    private String name;
    private String profile;

    private String aString;
//    private Bar aBar;
//
//    @AllArgsConstructor
//    public static class Bar {
//        private String aString;
//    }
}
