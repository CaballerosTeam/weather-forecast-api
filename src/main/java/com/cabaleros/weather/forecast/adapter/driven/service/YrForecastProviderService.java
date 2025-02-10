package com.cabaleros.weather.forecast.adapter.driven.service;

import com.cabaleros.weather.forecast.adapter.driven.model.YrCompactResponse;
import com.cabaleros.weather.forecast.application.core.domain.Forecast;
import com.cabaleros.weather.forecast.application.port.driven.ForecastProviderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class YrForecastProviderService implements ForecastProviderService {

  public static final String FORECAST_URI_PATTERN = "/weatherapi/locationforecast/2.0/compact?lat=%.4f&lon=%.4f";

  private final WebClient webClient;

  @Value("${weather-forecast.forecast-provider.host}")
  private String forecastProviderHost;

  @Override
  public Forecast getForecast(@NonNull Double lat, @NonNull Double lon) {


    return null;
  }

  @Override
  public Mono<YrCompactResponse> getRawForecast(@NonNull Double lat, @NonNull Double lon) {
    String forecastUri = getForecastUri(lat, lon);

    return webClient.get()
        .uri(forecastUri)
        .retrieve()
        .bodyToMono(YrCompactResponse.class)
        .doOnError(e -> log.error("Cannot fetch URI {}: {}", forecastUri, e.getMessage(), e));
  }

  String getForecastUri(Double lat, Double lon) {
    return forecastProviderHost + String.format(FORECAST_URI_PATTERN, lat, lon);
  }
}
