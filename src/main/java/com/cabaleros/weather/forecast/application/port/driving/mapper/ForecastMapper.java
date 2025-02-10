package com.cabaleros.weather.forecast.application.port.driving.mapper;

import com.cabaleros.weather.forecast.adapter.driven.model.YrCompactResponse;
import com.cabaleros.weather.forecast.adapter.driven.model.schema.YrForecastTimeStep;
import com.cabaleros.weather.forecast.adapter.driven.model.schema.YrInstantForecast;
import com.cabaleros.weather.forecast.adapter.driven.model.schema.YrNHoursForecast;
import com.cabaleros.weather.forecast.application.core.domain.Forecast;
import com.cabaleros.weather.forecast.application.core.domain.InstantForecast;
import com.cabaleros.weather.forecast.application.core.domain.PeriodForecast;
import com.cabaleros.weather.forecast.application.core.domain.TimeAwareForecast;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ForecastMapper {

  @Mapping(target = "timeseries", source = "properties.timeseries")
  Forecast map(YrCompactResponse yrCompactResponse);

  @Mapping(target = "timestamp", source = "time")
  @Mapping(target = "instant", source = "data.instant.details")
  TimeAwareForecast mapTimeAwareForecast(YrForecastTimeStep yrForecastTimeStep);

  @Mapping(target = "airTemperature.value", source = "airTemperature")
  @Mapping(target = "windSpeed.value", source = "windSpeed")
  InstantForecast mapInstantForecast(YrInstantForecast yrInstantForecast);

  @Mapping(target = "airTemperature.minValue", source = "airTemperatureMin")
  @Mapping(target = "airTemperature.maxValue", source = "airTemperatureMax")
  PeriodForecast mapPeriodForecast(YrNHoursForecast yrNHoursForecast);
}
