package com.cabaleros.weather.forecast.application.port.driving.service.impl;

import com.cabaleros.weather.forecast.adapter.driven.model.YrCompactResponse;
import com.cabaleros.weather.forecast.application.core.domain.Forecast;
import com.cabaleros.weather.forecast.application.port.driven.ForecastProviderService;
import com.cabaleros.weather.forecast.application.port.driving.mapper.ForecastMapper;
import com.cabaleros.weather.forecast.application.port.driving.service.ForecastService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ForecastServiceImpl implements ForecastService {

  private final ForecastProviderService forecastProviderService;
  private final ForecastMapper forecastMapper;

  @Override
  public Mono<Forecast> getForecast(@NonNull Double lat, @NonNull Double lon) {

    return forecastProviderService.getRawForecast(lat, lon)
        .map(forecastMapper::map);
  }

  @Override
  public Mono<YrCompactResponse> getRawForecast(@NonNull Double lat, @NonNull Double lon) {

    return forecastProviderService.getRawForecast(lat, lon);
  }
}
