package bootcamp.bootcoin.repository;

import bootcamp.bootcoin.model.BootcoinEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BootcoinRepository extends ReactiveMongoRepository <BootcoinEntity, String> {

    Flux<BootcoinEntity> findBootcoinById(String id);
}
