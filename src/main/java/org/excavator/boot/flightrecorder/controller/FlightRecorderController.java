package org.excavator.boot.flightrecorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/")
public class FlightRecorderController {

    @GetMapping("/")
    public Mono<String> home(){
        return Mono.just("Hello Flight Recorder");
    }
}
