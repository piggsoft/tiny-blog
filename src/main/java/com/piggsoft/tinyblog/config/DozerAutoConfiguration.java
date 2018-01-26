/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2018/1/25                           Create
 */
package com.piggsoft.tinyblog.config;

import com.github.dozermapper.spring.DozerBeanMapperFactoryBean;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author piggsoft
 * @version 1.0
 * @create 2018/1/25
 * @since 1.0
 */
@Configuration
@ConditionalOnClass({DozerBeanMapperFactoryBean.class, Mapper.class})
@ConditionalOnMissingBean(Mapper.class)
@EnableConfigurationProperties(DozerConfigurationProperties.class)
public class DozerAutoConfiguration {

    private final DozerConfigurationProperties configurationProperties;

    /**
     * Constructor for creating auto configuration.
     *
     * @param configurationProperties properties
     */
    @Autowired
    public DozerAutoConfiguration(DozerConfigurationProperties configurationProperties) {
        this.configurationProperties = configurationProperties;
    }

    /**
     * Creates default Dozer mapper
     *
     * @return Dozer mapper
     * @throws IOException if there is an exception during initialization.
     */
    @Bean
    public DozerBeanMapperFactoryBean dozerMapper() throws IOException {
        DozerBeanMapperFactoryBean factoryBean = new DozerBeanMapperFactoryBean();
        factoryBean.setMappingFiles(configurationProperties.getMappingFiles());
        return factoryBean;
    }
}
