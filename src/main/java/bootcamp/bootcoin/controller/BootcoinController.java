package bootcamp.bootcoin.controller;


import bootcamp.bootcoin.model.BootcoinEntity;
import bootcamp.bootcoin.service.iBootcoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/bootcoin")
public class BootcoinController {

    private final iBootcoinService service;

    @GetMapping
    public Flux<BootcoinEntity> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Flux<BootcoinEntity> getOne(@PathVariable String id) {
        return service.findBootcoinById(id);
    }

    @PostMapping
    public Mono<BootcoinEntity> create(@RequestBody BootcoinEntity bootcoin) {
        return service.save(bootcoin);
    }

    @PutMapping("/{id}")
    public Mono<BootcoinEntity> update(@RequestBody BootcoinEntity bootcoin) {
        return service.update(bootcoin);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
