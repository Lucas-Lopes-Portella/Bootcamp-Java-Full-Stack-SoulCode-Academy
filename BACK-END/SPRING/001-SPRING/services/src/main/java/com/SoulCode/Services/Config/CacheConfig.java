package com.SoulCode.Services.Config;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

//bean que informa que a classe é utilizada para configuração
@Configuration
public class CacheConfig {

   // serve para converter json para redis e vice-versa
   // serializationpair serve para transformar json para redis e vice versa
   private final RedisSerializationContext.SerializationPair<Object> serializationPair = RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());


   // transformar par a o formato que o redis suporta
   // Método para informar o per
      @Bean
   public RedisCacheConfiguration cacheConfiguration(){
         return  RedisCacheConfiguration // customizar
                 .defaultCacheConfig()
                 .entryTtl(Duration.ofMinutes(5)) // informa que todos os caches terão 5 minutos por padrão (tempo de vida)
                 .disableCachingNullValues() // // não salva valores nulos
                 .serializeValuesWith(serializationPair); // converte do redis p/ json e vice-versa


      }

      // Método para criar caches personalizados
      @Bean
      public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer(){
         return (builder) -> builder
                 .withCacheConfiguration("clientCache",
                     RedisCacheConfiguration
                         .defaultCacheConfig().entryTtl(Duration.ofSeconds(30))
                         .serializeValuesWith(serializationPair)

                 ).withCacheConfiguration(
                         "calledCache",
                         RedisCacheConfiguration
                                 .defaultCacheConfig()
                                 .entryTtl(Duration.ofSeconds(50000000))
                                 .serializeValuesWith(serializationPair)
                 ).withCacheConfiguration(
                         "userCache",
                         RedisCacheConfiguration
                                 .defaultCacheConfig()
                                 .entryTtl(Duration.ofSeconds(5))
                                 .serializeValuesWith(serializationPair)
                 ).withCacheConfiguration(
                         "usernameCache",
                         RedisCacheConfiguration
                                 .defaultCacheConfig()
                                 .entryTtl(Duration.ofHours(1))
                                 .serializeValuesWith(serializationPair)
                 )
                 ;
      }
}
