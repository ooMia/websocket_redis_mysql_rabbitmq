package com.sinor.backend.caching.demo;

import com.sinor.backend.caching.demo.model.DemoResponse;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends CrudRepository<DemoResponse, String> {

}
