package com.cabaleros.weather.forecast.application.port.driving.service;

import com.cabaleros.weather.forecast.adapter.driven.model.YrCompactResponse;
import com.cabaleros.weather.forecast.application.core.domain.Forecast;
import reactor.core.publisher.Mono;

public interface ForecastService {

  Mono<Forecast> getForecast(Double lat, Double lon);

  Mono<YrCompactResponse> getRawForecast(Double lat, Double lon);
}
