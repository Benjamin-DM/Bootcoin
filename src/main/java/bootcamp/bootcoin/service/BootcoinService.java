package bootcamp.bootcoin.service;

import bootcamp.bootcoin.model.BootcoinEntity;
import bootcamp.bootcoin.repository.BootcoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class BootcoinService  implements BootcoinServiceRed{
    private final KafkaTemplate<String, BootcoinEntity> kafkaTemplate;
    private final BootcoinRepository repository;
    private static final String TOPIC_NAME = "demo";

    @Override
    public Flux<BootcoinEntity> findAll() {
        return repository.findAll();
    }


    @Override
    public Mono<BootcoinEntity> create(BootcoinEntity bootcoin) {
        return repository.insert(bootcoin)
                .map(this::sendToKafka);
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
    public BootcoinEntity sendToKafka(BootcoinEntity bootcoin) {
        kafkaTemplate.send(TOPIC_NAME, bootcoin.getNumCelular(), bootcoin)
                .addCallback(result -> {
                    var resultNonNull = Objects.requireNonNull(result);
                    log.info("response: {}", resultNonNull.getProducerRecord());
                }, Throwable::printStackTrace);
        return bootcoin;
    }

}
