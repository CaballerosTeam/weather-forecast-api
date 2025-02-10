package com.cabaleros.weather.forecast.application.port.driven;

import com.cabaleros.weather.forecast.adapter.driven.model.YrCompactResponse;
import com.cabaleros.weather.forecast.application.core.domain.Forecast;
import reactor.core.publisher.Mono;

public interface ForecastProviderService {

  Forecast getForecast(Double lat, Double lon);

  Mono<YrCompactResponse> getRawForecast(Double lat, Double lon);
}
