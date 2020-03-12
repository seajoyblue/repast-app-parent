package com.longlong.repast.config;

import com.longlong.repast.properties.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @autor: 日思夜想的龙哥哥
 * @date: 2020-03-09
 * @Description:
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisCluster getJedisCluster(){
        String nodes = redisProperties.getNodes();
        String[] nodesArray = nodes.split(",");
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
        for (String hostPort : nodesArray) {
            String[] ipAndPort = hostPort.split(":");
            HostAndPort hostAndPort = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
            hostAndPortSet.add(hostAndPort);
            JedisCluster jedisCluster = new JedisCluster(hostAndPortSet, redisProperties.getCommandTimeout(), redisProperties.getMaxAttempts());
            return jedisCluster;
        }
    }
}
