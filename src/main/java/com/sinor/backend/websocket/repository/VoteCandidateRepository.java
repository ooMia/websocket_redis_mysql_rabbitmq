package com.sinor.backend.websocket.repository;

import com.sinor.backend.websocket.model.entity.VoteCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteCandidateRepository extends JpaRepository<VoteCandidate, Long> {
}
