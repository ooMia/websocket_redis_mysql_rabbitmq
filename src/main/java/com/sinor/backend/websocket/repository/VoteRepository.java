package com.sinor.backend.websocket.repository;

import com.sinor.backend.websocket.model.entity.board.vote.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}
