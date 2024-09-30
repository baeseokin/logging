package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiService {
    private final WebClient webClient;

    public ApiService(WebClient webClient){
        this.webClient = webClient;
    }

    public Mono<String> sendJsonToExternalApi(String jsonStr){
        String url = "http://elastic:elastic1234@localhost:5055/";

        return webClient.post()
                .uri(url)
                .header("Content-Type","application/json")
                .bodyValue(jsonStr)
                .retrieve()
                .bodyToMono(String.class);

    }


}
