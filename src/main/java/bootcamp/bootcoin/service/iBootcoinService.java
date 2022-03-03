package bootcamp.bootcoin.service;

import bootcamp.bootcoin.model.BootcoinEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface iBootcoinService {

    Flux<BootcoinEntity> findAll();

    Flux<BootcoinEntity> findBootcoinById(String id);

    Mono<BootcoinEntity> save(BootcoinEntity bootcoin);

    Mono<BootcoinEntity> update(BootcoinEntity bootcoin);

    Mono <Void> delete(String id);
}
