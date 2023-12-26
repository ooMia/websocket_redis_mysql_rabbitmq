package com.sinor.backend.websocket.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(indexes = @Index(name = "fk_board_id", columnList = "board_id"))
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private LocalDateTime validUntil;
    private Boolean isAnonymous;
    private Boolean isMultiple;

    @Column(name = "board_id")
    private Long boardId;

    @Builder
    public Vote(String title, LocalDateTime validUntil, Boolean isAnonymous, Boolean isMultiple, Long boardId) {
        this.title = title;
        this.validUntil = validUntil;
        this.isAnonymous = isAnonymous;
        this.isMultiple = isMultiple;
        this.boardId = boardId;
    }
}
