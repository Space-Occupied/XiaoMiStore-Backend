package com.darkquantum.xiaomistore.user.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.Duration;

@Configuration
@EnableCaching
@EnableTransactionManagement
@EnableRedisHttpSession
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory, ObjectMapper objectMapper) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);//设置连接工厂

        //设置key序列化器，要求key必须是字符串
        redisTemplate.setKeySerializer(RedisSerializer.string());

        ObjectMapper om = objectMapper.copy();

        //设置value序列化器
        RedisSerializer<Object> valueSerializer = GenericJackson2JsonRedisSerializer
                .builder().objectMapper(om).defaultTyping(true).build();
        redisTemplate.setValueSerializer(valueSerializer);

        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        redisTemplate.setHashValueSerializer(valueSerializer);

        //启用事务支持
        redisTemplate.setEnableTransactionSupport(true);

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory cf, ObjectMapper om) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(cf);

        //设置value序列化器
        RedisSerializer<Object> valueSerializer = GenericJackson2JsonRedisSerializer
                .builder().objectMapper(om.copy()).defaultTyping(true).build();
        //配置类
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext
                        .SerializationPair.fromSerializer(valueSerializer))
                .entryTtl(Duration.ofSeconds(30_000));// 设置缓存全局统一有效期，ttl表示time to live，即存活时间。

        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }
}
