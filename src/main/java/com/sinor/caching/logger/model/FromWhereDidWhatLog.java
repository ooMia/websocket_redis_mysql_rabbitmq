package com.sinor.caching.logger.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class FromWhereDidWhatLog extends BaseLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String method;
    protected String scheme;
    protected String host;
    protected String path;
    protected String queryString;
    protected Integer statusCode;

    public FromWhereDidWhatLog(LogDto logDto) {
        super();
        this.scheme = logDto.request().getScheme();
        this.method = logDto.request().getMethod();
        this.host = logDto.request().getRemoteHost();
        this.path = logDto.request().getServletPath();
        this.queryString = logDto.request().getQueryString();
        this.statusCode = logDto.response().getStatus();
    }

    @Override
    public String toString() {
        return "FromWhereDidWhatLog{" +
                "id=" + id +
                ", scheme='" + scheme + '\'' +
                ", host='" + host + '\'' +
                ", path='" + path + '\'' +
                ", queryString='" + queryString + '\'' +
                ", statusCode=" + statusCode +
                ", createdAt=" + createdAt +
                ", currentAt=" + currentAt +
                '}';
    }
}
