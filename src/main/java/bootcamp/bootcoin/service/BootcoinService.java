package bootcamp.bootcoin.service;

import bootcamp.bootcoin.model.BootcoinEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BootcoinService  implements iBootcoinService{


    @Override
    public Flux<BootcoinEntity> findAll() {
        return null;
    }

    @Override
    public Mono<BootcoinEntity> findBootcoinById(String id) {
        return null;
    }


    @Override
    public Mono<BootcoinEntity> save(BootcoinEntity bootcoin) {
        return null;
    }

    @Override
    public Mono<BootcoinEntity> update(BootcoinEntity bootcoin) {
        return null;
    }

    @Override
    public Mono<Void> delete(String id) {
        return null;
    }


}
