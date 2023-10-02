package org.spring.cloud.config.server.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentProperties;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentRepository;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentRepositoryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Profile("jdbc")
@ConditionalOnClass(JdbcTemplate.class)
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(value = "spring.cloud.config.server.jdbc.enabled", matchIfMissing = true)
class JdbcRepositoryConfiguration {

    @Bean
    @ConditionalOnBean(JdbcTemplate.class)
    public JdbcEnvironmentRepository jdbcEnvironmentRepository(JdbcEnvironmentRepositoryFactory factory,
                                                               JdbcEnvironmentProperties environmentProperties) {
        return factory.build(environmentProperties);
    }
}