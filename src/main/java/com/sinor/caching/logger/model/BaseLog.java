package com.sinor.caching.logger.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.SourceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class BaseLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    @CreationTimestamp(source = SourceType.DB)
    protected LocalDateTime createdAt;

    @CurrentTimestamp(source = SourceType.VM)
    protected LocalDateTime currentAt;
}
