package com.sinor.backend.websocket.model.entity.board.vote;

import com.sinor.backend.websocket.common.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class VoteCandidate implements BaseEntity<Long> {
    // parent
    private Long voteId;

    // vote > vote_candidate > vote_log
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // child
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "voteCandidateId")
    private Set<VoteLog> voteLogs;

    // properties
    private String content;

    @Builder
    public VoteCandidate(Long voteId, String content) {
        this.voteId = voteId;
        this.content = content;
    }

}
