package com.sinor.backend.websocket.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime validUntil;
    private Boolean isAnonymous;
    private Boolean isMultiple;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Board board;
}
