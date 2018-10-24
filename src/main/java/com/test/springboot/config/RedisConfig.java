package com.test.springboot.config;

import com.google.common.collect.Maps;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;
import java.util.Map;

/**
 * @date : 2018/10/24 15:54
 * @author: liangenmao
 */
@Configuration
@ImportAutoConfiguration(RedissonAutoConfiguration.class)
@AutoConfigureBefore(RedissonAutoConfiguration.class)
public class RedisConfig {
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxTotal;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.host}")
    private String hostName;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.database}")
    private int database;
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        return jedisPoolConfig;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        //TODO 方法过时了
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(hostName);
        factory.setPort(port);
        factory.setDatabase(database);
        factory.setPassword(password);
        factory.setPoolConfig(jedisPoolConfig());
        factory.setUsePool(true);
        return factory;
    }

    @Bean
    public RedisTemplate<String,String> redisTemplate(){
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    /*@Bean(name = "myRedisTemplate")
    public RedisTemplate<Object,Object> myRedisTemplate(){
        RedisTemplate<Object,Object> myRedisTemplate = new RedisTemplate<>();
        myRedisTemplate.setConnectionFactory(jedisConnectionFactory());

        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        myRedisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        myRedisTemplate.setEnableDefaultSerializer(true);
        *//*myRedisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
        myRedisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
        myRedisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        myRedisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);*//*
        return myRedisTemplate;
    }*/

    @Bean
    public CacheManager cacheManager() {
        CacheKeyPrefix prefix  = cacheName -> "cache:" + cacheName + ":";
        //String prefix = "cache:";
        RedisCacheConfiguration configuration3 = RedisCacheConfiguration.defaultCacheConfig()
                .computePrefixWith(prefix).entryTtl(Duration.ofHours(3));
        RedisCacheConfiguration configuration6 = RedisCacheConfiguration.defaultCacheConfig()
                .computePrefixWith(prefix).entryTtl(Duration.ofHours(6));

        Map<String,RedisCacheConfiguration> map = Maps.newHashMap();
        map.put("cache3",configuration3);
        map.put("cache6",configuration6);

        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.
                RedisCacheManagerBuilder.fromConnectionFactory(jedisConnectionFactory());
        return builder.withInitialCacheConfigurations(map).build();
    }


}
