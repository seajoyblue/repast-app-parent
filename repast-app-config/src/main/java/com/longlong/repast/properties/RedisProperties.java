package com.longlong.repast.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-09
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
@PropertySource("classpath:properties/redis.properties")
@Data
public class RedisProperties {

    private String nodes;
    private Integer maxAttempts;
    private Integer commandTimeout;
}
