package bootcamp.bootcoin.service;

import bootcamp.bootcoin.model.BootcoinEntity;
import bootcamp.bootcoin.repository.BootcoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BootcoinService  implements iBootcoinService{

    private final BootcoinRepository repository;

    @Override
    public Flux<BootcoinEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Flux<BootcoinEntity> findBootcoinById(String id) {
        return repository.findBootcoinById(id);
    }


    @Override
    public Mono<BootcoinEntity> save(BootcoinEntity bootcoin) {
        return repository.save(bootcoin);
    }

    @Override
    public Mono<BootcoinEntity> update(BootcoinEntity bootcoin) {
        return repository.save(bootcoin);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }


}
