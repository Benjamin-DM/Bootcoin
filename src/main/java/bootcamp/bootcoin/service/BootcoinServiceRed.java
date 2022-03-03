package bootcamp.bootcoin.service;

import bootcamp.bootcoin.model.BootcoinEntity;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCacheEvict;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCachePut;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCacheable;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCaching;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootcoinServiceRed extends iBootcoinService {
    static String CACHE_NAME = "bootcoins";

    @ReactiveRedisCacheable(cacheName = CACHE_NAME, key = "'findAll'")
    Flux<BootcoinEntity> findAll();

    @ReactiveRedisCacheable(cacheName = CACHE_NAME, key = "'findOneById_' + #id")
    Flux<BootcoinEntity> findBootcoinById(String id);

    @ReactiveRedisCacheEvict(cacheName = CACHE_NAME, allEntries = true)
    Mono<BootcoinEntity> create(BootcoinEntity bootcoin);

    @ReactiveRedisCaching(
            evict = {@ReactiveRedisCacheEvict(cacheName = CACHE_NAME, key = "findAll"),},
            put = {
                    @ReactiveRedisCachePut(cacheName = CACHE_NAME, key = "'findOneById_' + #bootcoin.id"),
            }
    )
    Mono<BootcoinEntity> update(BootcoinEntity bootcoin);

    @ReactiveRedisCacheEvict(cacheName = CACHE_NAME, key = "'findById_' + #id")
    Mono<Void> delete(String id);
}
