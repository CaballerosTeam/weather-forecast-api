package com.cabaleros.weather.forecast.adapter.driving.controller;

import com.cabaleros.weather.forecast.adapter.driven.mapper.ForecastResponseMapper;
import com.cabaleros.weather.forecast.adapter.driving.model.ForecastResponse;
import com.cabaleros.weather.forecast.application.port.driving.service.ForecastService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ForecastController implements ForecastApi {

  private final ForecastService forecastService;
  private final ForecastResponseMapper forecastResponseMapper;

  @Override
  @CrossOrigin(origins = "*")
  public Mono<ResponseEntity<ForecastResponse>> getForecastByCoordinates(Double lat, Double lon,
      ServerWebExchange exchange) {
    ServerHttpRequest request = exchange.getRequest();
    HttpHeaders headers = request.getHeaders();
    List<String> strings = headers.get("X-Request-ID");

    if (!CollectionUtils.isEmpty(strings)) {
      log.info("Request ID: {}", strings.getFirst());
    }

    return forecastService.getForecast(lat, lon)
        .map(forecast -> {
          ForecastResponse forecastResponse = forecastResponseMapper.map(forecast);
          return ResponseEntity.ok(forecastResponse);
        })
        .doOnError(e -> {
          log.error("Unexpected error during getting the forecast: lat {}; lon {}: {}", lat, lon, e.getMessage(), e);
          exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        });
  }

  @Override
  public Mono<ResponseEntity<String>> getRawForecastByCoordinates(Double lat, Double lon, ServerWebExchange exchange) {
    return forecastService.getForecast(lat, lon)
        .map(response -> {
          log.info("{}", response);
          return ResponseEntity.ok(response.toString());
        })
        .onErrorReturn(ResponseEntity.internalServerError().body("{\"message\": \"fail\"}"));
  }
}
