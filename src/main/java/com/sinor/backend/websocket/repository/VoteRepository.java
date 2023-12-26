package com.sinor.backend.websocket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends CrudRepository<VoteRepository, Long> {
}
