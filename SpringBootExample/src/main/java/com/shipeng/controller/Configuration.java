package com.shipeng.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@org.springframework.context.annotation.Configuration
@PropertySource("file:///opt/opinmind/conf/common.properties")
@PropertySource("file:///opt/opinmind/conf/discovery-engine.properties")
public class Configuration {

    @Value("${google_cloud.adara.discovery.project_id}")
    private String gcpProjectId;

    @Value("${google_cloud.adara.discovery.dataset}")
    private String bqDatasetId;

    @Value("${discovery.group.query.executor.thread.pool.size}")
    private int threadPoolSize;

    @Bean(name="gcpProjectId")
    public String getGcpProjectId() {
        return this.gcpProjectId;
    }

    @Bean(name="bqDatasetId")
    public String getBqDatasetId() {
        return this.bqDatasetId;
    }

    @Bean(name="threadPoolSize")
    public int getThreadPoolSize() {
        return this.threadPoolSize;
    }

}
